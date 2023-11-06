package com.example.orderservice.dto;

/*
 * 서버에서 응답하는 Order 와 관련된 DTO
 *
 * */

import com.example.orderservice.model.Order;
import com.example.orderservice.util.OrderDTOUtil;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class OrderResponseDTO {

    private OrderResponseDTO() {
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlaceOrderResponse {
        private String orderNumber;
        private List<OrderLineItemsResponseDTO.PlaceOrderLineItemResponse> itemDTOList;

        public PlaceOrderResponse(Order order) {
            this.orderNumber = order.getOrderNumber();
            this.itemDTOList = order.getOrderLineItemsList().stream().map(OrderDTOUtil::toOrderLineItemDTO).toList();
        }

    }
}
