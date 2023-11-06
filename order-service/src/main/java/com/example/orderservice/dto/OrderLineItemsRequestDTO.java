package com.example.orderservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;


public class OrderLineItemsRequestDTO {

    private OrderLineItemsRequestDTO() {
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class OrderRequestItem {
        private String skuCode;
        private BigDecimal price;
        private Integer quantity;
    }

}
