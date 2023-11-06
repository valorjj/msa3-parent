package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductServiceV1 {

    void createProduct(ProductRequest.CreateProductRequestDTO createProductRequestDTO);

    List<ProductResponse.CreateProductResponseDTO> getAllProducts();
}
