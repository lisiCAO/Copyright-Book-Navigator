package com.lisi.booknavigator.productservice.repository;

import com.lisi.booknavigator.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
