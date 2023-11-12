package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponseDTO;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;

import java.util.Collections;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventoryServiceImplV2 implements InventoryServiceV2 {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public List<InventoryResponseDTO.InventoryInStockRes> isInStock(List<String> skuCodes) {
        List<InventoryResponseDTO.InventoryInStockRes> list = inventoryRepository.findBySkuCodeIn(skuCodes).stream()
            .map(InventoryServiceImplV2::apply)
            .toList();
        // 재고가 없는 경우 에러 발생
        if (list.isEmpty()) {
            return Collections.emptyList();
        }

        /*
         * 재고가 존재해서 주문이 가능한 경우, 해당 제품의 수량을 감소시킨다.
         * */
        for (String skuCode : skuCodes) {
            inventoryRepository.findBySkuCode(skuCode).ifPresent(value -> value.decreaseQuantity(1));
        }

        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
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
