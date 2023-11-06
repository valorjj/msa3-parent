package com.example.productservice.dto;

import com.example.productservice.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class ProductRequest {

    private ProductRequest() {
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CreateProductRequestDTO {
        private String name;
        private String desc;
        private BigDecimal price;
    }

    public static Product toEntity(CreateProductRequestDTO dto) {
        return Product.builder()
            .name(dto.getName())
            .desc(dto.getDesc())
            .price(dto.getPrice())
            .build();
    }


}
