package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplV1 implements ProductServiceV1 {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest.CreateProductRequestDTO createProductRequestDTO) {
        Product product;
        product = ProductRequest.toEntity(createProductRequestDTO);

        productRepository.save(product);
    }

    @Override
    public List<ProductResponse.CreateProductResponseDTO> getAllProducts() {
        List<Product> products;

        products = productRepository.findAll();
        return products.stream().map(ProductResponse::toDTO).toList();
    }

}
