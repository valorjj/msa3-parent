package com.example.orderservice.dto;


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
    public static class InventoryInStockResponse {
        /*
        * Reflection 에러 로그를 보고
        * @NoArgsConstructor
        * @AllArgsConstructor
        * 어노테이션을 붙였다.
        * Reflection 을 사용하기 위해서는 @Getter 와 빈 생성자가 필요하다
        * */

        private String skuCode;
        private boolean isInStock;
    }
}
