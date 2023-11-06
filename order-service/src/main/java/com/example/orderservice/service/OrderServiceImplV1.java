package com.example.orderservice.service;

import com.example.orderservice.client.InventoryClient;
import com.example.orderservice.dto.InventoryResponseDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.event.OrderPlacedEvent;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.util.OrderDTOUtil;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImplV1 implements OrderServiceV1 {

    private final OrderRepository repository;
    private final InventoryClient inventoryClient;
    private final Tracer tracer;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;


    @Override
    @Transactional
    public String placeOrder(OrderRequestDTO.PlaceOrderRequest orderRequestDTO) {
        Order orderPS;
        List<OrderLineItems> orderLineItems;

        orderLineItems = orderRequestDTO.getItemDTOList()
            .stream()
            .map(OrderDTOUtil::toOrderLineEntity)
            .toList();

        // 리스트를 엔티티에 주입한다.
        orderPS = OrderDTOUtil.saveLineItems(orderLineItems);

        // 리스트에서 skuCode 만을 뽑는다.
        List<String> skuCodes = orderPS.getOrderLineItemsList().stream()
            .map(OrderLineItems::getSkuCode)
            .toList();

        Span inventoryServiceLookup = tracer.nextSpan().name("InventoryServiceLookup");
        try (Tracer.SpanInScope spanInScope = tracer.withSpan(inventoryServiceLookup.start())) {
            List<InventoryResponseDTO.InventoryInStockResponse> inventoryList = inventoryClient.isInStock(skuCodes);
            boolean allProductsInStock = false;
            // 리스트가 0인 경우, 무조건 true 를 반환하기 때문에
            // 리스트의 사이즈가 0인지 검사한다.
            if (!inventoryList.isEmpty())
                /*
                 * allMatch 는 모든 아이템의 isInStock 여부가 true 인지 검사한다.
                 * n번의 db 조회를 막기위한 로직이다.
                 * 전체를 1번 조회하고,
                 * 부족한 아이템을 알려주고 제외하도록 작성하면 된다.
                 * */
                allProductsInStock = inventoryList
                    .stream()
                    .allMatch(InventoryResponseDTO.InventoryInStockResponse::isInStock);

            // 재고가 있는 경우
            if (allProductsInStock) {
                // 데이터베이스에 주문내역을 저장한다.
                Order savedOrder = repository.save(orderPS);
                kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(savedOrder.getOrderNumber()));
                return "Order has been placed successfully";
            }
            // 재고가 없는 경우, 예외를 발생시킨다.
            else {
                throw new IllegalStateException("재고가 부족합니다.");
            }
        } finally {
            inventoryServiceLookup.end();
        }
    }
}
