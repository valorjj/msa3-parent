package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.service.OrderServiceV1;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Log4j2
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(
        @RequestBody OrderRequestDTO.PlaceOrderRequest orderRequestDTO
    ) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequestDTO));
    }

    public CompletableFuture<String> fallbackMethod(
        OrderRequestDTO.PlaceOrderRequest orderRequestDTO,
        RuntimeException runtimeException
    ) {
        return CompletableFuture.supplyAsync(() -> "Sorry, Something went wrong. Please try after a few minute.");
    }


}
