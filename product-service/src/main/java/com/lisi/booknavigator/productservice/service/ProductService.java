package com.lisi.booknavigator.productservice.service;

import com.lisi.booknavigator.productservice.dto.ProductRequest;
import com.lisi.booknavigator.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

    }
}
