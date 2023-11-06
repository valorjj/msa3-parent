package com.example.inventoryservice.service;

import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImplV1 implements InventoryServiceV1 {

    private final InventoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return repository.findBySkuCode(skuCode).isPresent();
    }
}
