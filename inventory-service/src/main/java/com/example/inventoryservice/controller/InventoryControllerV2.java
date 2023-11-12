package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponseDTO;
import com.example.inventoryservice.service.InventoryServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryControllerV2 {

    private final InventoryServiceV2 inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDTO.InventoryInStockRes> isInStock(
        @RequestParam List<String> skuCodes
    ) {
        log.info("[*] 재고를 확인합니다.");
        return inventoryService.isInStock(skuCodes);
    }


}
