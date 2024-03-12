package com.lisi.booknavigator.searchservice.service;

import com.lisi.booknavigator.searchservice.event.ProductEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventHandler {

    private final ElasticsearchService elasticsearchService;

    @Autowired
    public ProductEventHandler(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;
    }

    @KafkaListener(topics = "product-changes", groupId = "search-service-group")
    public void listenProductChanges(ProductEvent event) {
        // 根据事件类型进行处理
        switch (event.getEventType()) {
            case CREATE:
            case UPDATE:
                elasticsearchService.saveOrUpdateProduct(event.getProduct());
                break;
            case DELETE:
                elasticsearchService.deleteProduct(event.getProductId());
                break;
        }
    }
}
