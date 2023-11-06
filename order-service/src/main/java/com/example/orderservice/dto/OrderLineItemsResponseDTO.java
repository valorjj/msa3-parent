package com.example.orderservice.dto;

import com.example.orderservice.model.OrderLineItems;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;


public class OrderLineItemsResponseDTO {

    private OrderLineItemsResponseDTO() {

    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PlaceOrderLineItemResponse {
        private String skuCode;
        private BigDecimal price;
        private Integer quantity;

        public PlaceOrderLineItemResponse(OrderLineItems item) {
            this.skuCode = item.getSkuCode();
            this.price = item.getPrice();
            this.quantity = item.getQuantity();
        }

    }


}
