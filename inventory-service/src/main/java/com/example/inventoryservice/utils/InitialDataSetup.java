package com.example.inventoryservice.utils;

import com.example.inventoryservice.dto.InventoryRequestDTO;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitialDataSetup implements CommandLineRunner {

    private final InventoryRepository repository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // some random init data
        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("macbook-pro")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("macbook-air")
                .quantity(9999)
                .build()
        ));


        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("ipad-pro")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("ipad-air")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("iphone-15")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("iphone-15-pro")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("watch")
                .quantity(9999)
                .build()
        ));

        repository.save(InventoryUtil.toEntity(
            InventoryRequestDTO.InventoryInStock.builder()
                .skuCode("watch-ultra")
                .quantity(9999)
                .build()
        ));

    }
}
