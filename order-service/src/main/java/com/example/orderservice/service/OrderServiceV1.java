package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequestDTO;

public interface OrderServiceV1 {

    String placeOrder(OrderRequestDTO.PlaceOrderRequest orderRequestDTO);

}
