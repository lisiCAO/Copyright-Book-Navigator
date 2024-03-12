package com.lisi.booknavigator.searchservice.service;

import com.lisi.booknavigator.searchservice.entity.Product;
import com.lisi.booknavigator.searchservice.event.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElasticsearchService {

    private final ElasticsearchOperations elasticsearchOperations;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public List<Product> search(String processQuery) {
        Criteria criteria = new Criteria("name").contains(processQuery)
                .or(new Criteria("description").contains(processQuery));
        Query searchQuery = new CriteriaQuery(criteria);
        SearchHits<Product> searchHits = elasticsearchOperations.search(searchQuery, Product.class);
        return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public void saveOrUpdateProduct(Product product) {
        elasticsearchOperations.save(product);
    }

    public void deleteProduct(String productId) {
        elasticsearchOperations.delete(productId, Product.class);
    }
}
