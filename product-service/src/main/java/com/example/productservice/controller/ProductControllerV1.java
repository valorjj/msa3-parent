package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.service.ProductServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductControllerV1 {

    private final ProductServiceV1 productServiceV1;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest.CreateProductRequestDTO createProductRequestDTO) {
        productServiceV1.createProduct(createProductRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse.CreateProductResponseDTO> getAllProducts() {
        return productServiceV1.getAllProducts();
    }

}
