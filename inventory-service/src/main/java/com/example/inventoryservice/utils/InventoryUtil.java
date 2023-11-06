package com.example.inventoryservice.utils;

import com.example.inventoryservice.dto.InventoryRequestDTO;
import com.example.inventoryservice.model.Inventory;

public class InventoryUtil {

    private InventoryUtil() {
    }
    public static Inventory toEntity(InventoryRequestDTO.InventoryInStock dto) {
        return Inventory.builder()
            .skuCode(dto.getSkuCode())
            .quantity(dto.getQuantity())
            .build();
    }
}
