package com.example.orderservice.client;

import com.example.orderservice.dto.InventoryResponseDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange(url = "http://inventory-service/api/v2/inventory")
@LoadBalancerClient
public interface InventoryClient {

    @GetExchange
    List<InventoryResponseDTO.InventoryInStockResponse> isInStock(@RequestParam List<String> skuCodes);

}
