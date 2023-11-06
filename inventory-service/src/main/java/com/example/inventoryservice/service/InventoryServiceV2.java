package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponseDTO;

import java.util.List;

public interface InventoryServiceV2 {

    List<InventoryResponseDTO.InventoryInStockRes> isInStock(List<String> skuCodes);

}
