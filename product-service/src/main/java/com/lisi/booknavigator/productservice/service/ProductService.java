package com.lisi.booknavigator.productservice.service;

import com.lisi.booknavigator.productservice.dto.ProductRequest;
import com.lisi.booknavigator.productservice.model.Product;
import com.lisi.booknavigator.productservice.repository.ProductRepository;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstrucctor
public class ProductService {

    private final ProductRepository productRespProductRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
}
