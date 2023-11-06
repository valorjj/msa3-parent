package com.example.productservice.dto;

import com.example.productservice.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class ProductResponse {

    private ProductResponse() {
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CreateProductResponseDTO {
        private String id;
        private String name;
        private String desc;
        private BigDecimal price;
    }

    public static CreateProductResponseDTO toDTO(Product product) {
        return CreateProductResponseDTO.builder()
            .name(product.getName())
            .desc(product.getDesc())
            .price(product.getPrice())
            .build();
    }

}
