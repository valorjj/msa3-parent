package com.example.productservice.utils;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.repository.ProductRepository;
import jakarta.ws.rs.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class InitialDataSetup implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // insert initial data for test purpose
        try {
            productRepository.save(ProductRequest.toEntity(ProductRequest.CreateProductRequestDTO.builder()
                .name("macbook-pro")
                .desc("highest spec macbook")
                .price(BigDecimal.valueOf(10000))
                .build()));
            productRepository.save(ProductRequest.toEntity(ProductRequest.CreateProductRequestDTO.builder()
                .name("macbook-air")
                .desc("middle spec macbook")
                .price(BigDecimal.valueOf(5000))
                .build()));
            productRepository.save(ProductRequest.toEntity(ProductRequest.CreateProductRequestDTO.builder()
                .name("ipad-pro")
                .desc("highest spec ipad")
                .price(BigDecimal.valueOf(3000))
                .build()));
            productRepository.save(ProductRequest.toEntity(ProductRequest.CreateProductRequestDTO.builder()
                .name("ipad-air")
                .desc("middle spec ipad")
                .price(BigDecimal.valueOf(1000))
                .build()));
        } catch (Exception e) {
            e.getLocalizedMessage();
            throw new InternalServerErrorException("MongoDB 와 연결에 실패했습니다.");
        }

    }
}
