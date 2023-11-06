package com.example.inventoryservice.controller;

import com.example.inventoryservice.service.InventoryServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryControllerV1 {

    private final InventoryServiceV1 inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(
        @PathVariable("sku-code") String skuCode
    ) {
        return inventoryService.isInStock(skuCode);
    }


}
