package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponseDTO;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventoryServiceImplV2 implements InventoryServiceV2 {

    private final InventoryRepository repository;

    @SneakyThrows
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponseDTO.InventoryInStockRes> isInStock(List<String> skuCodes) {
        log.info("Wait started");
        Thread.sleep(40000);
        log.info("Wait ended");
        return repository.findBySkuCodeIn(skuCodes).stream()
            .map(InventoryServiceImplV2::apply)
            .toList();
    }

    private static InventoryResponseDTO.InventoryInStockRes apply(Inventory i) {
        return InventoryResponseDTO.InventoryInStockRes.builder()
            .skuCode(i.getSkuCode())
            .isInStock(i.getQuantity() > 0)
            .build();
    }

}
