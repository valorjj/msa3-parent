package com.example.orderservice.util;

import com.example.orderservice.dto.OrderLineItemsRequestDTO;
import com.example.orderservice.dto.OrderLineItemsResponseDTO;
import com.example.orderservice.dto.OrderResponseDTO;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OrderDTOUtil {

    private OrderDTOUtil() {
    }

    public static Order saveLineItems(List<OrderLineItems> orderLineItems) {
        return Order.builder()
            .orderLineItemsList(orderLineItems)
            .orderNumber(UUID.randomUUID().toString())
            .build();
    }

    public static OrderResponseDTO.PlaceOrderResponse toOrderResponseDTO(Order order) {
        return new OrderResponseDTO.PlaceOrderResponse(order);
    }

    public static OrderLineItems toOrderLineEntity(OrderLineItemsRequestDTO.OrderRequestItem dto) {
        return OrderLineItems.builder()
            .price(dto.getPrice())
            .quantity(dto.getQuantity())
            .skuCode(dto.getSkuCode())
            .build();
    }

    public static OrderLineItemsResponseDTO.PlaceOrderLineItemResponse toOrderLineItemDTO(OrderLineItems item) {
        return new OrderLineItemsResponseDTO.PlaceOrderLineItemResponse(item);
    }


}
