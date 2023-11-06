package com.example.inventoryservice.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class InventoryResponseDTO {


    private InventoryResponseDTO() {

    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InventoryInStockRes {
        private String skuCode;
        private boolean isInStock;
    }
}
