package com.lisi.booknavigator.searchservice.repository;

import com.lisi.booknavigator.searchservice.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
