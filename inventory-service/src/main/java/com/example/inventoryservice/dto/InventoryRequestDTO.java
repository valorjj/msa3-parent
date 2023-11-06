package com.example.inventoryservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

public class InventoryRequestDTO {

    private InventoryRequestDTO() {

    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Data
    @Builder
    public static class InventoryInStock {
        private String skuCode;
        private Integer quantity;
    }


}
