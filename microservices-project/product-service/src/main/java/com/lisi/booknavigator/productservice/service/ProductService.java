package com.lisi.booknavigator.productservice.service;

import com.lisi.booknavigator.productservice.dto.ProductRequest;
import com.lisi.booknavigator.productservice.dto.ProductResponse;
import com.lisi.booknavigator.productservice.event.ProductEvent;
import com.lisi.booknavigator.productservice.model.Product;
import com.lisi.booknavigator.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public void createProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        Product savedProduct = productRepository.save(product);

        ProductEvent event = new ProductEvent(savedProduct.getId(), ProductEvent.EventType.CREATE, savedProduct);
        kafkaTemplate.send("productTopic",event);

        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
