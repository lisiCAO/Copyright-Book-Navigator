package com.lisi.booknavigator.productservice.controller;

import com.lisi.booknavigator.productservice.dto.ProductRequest;
import com.lisi.booknavigator.productservice.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstrucctor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
}
