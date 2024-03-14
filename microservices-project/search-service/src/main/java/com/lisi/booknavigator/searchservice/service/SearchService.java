package com.lisi.booknavigator.searchservice.service;

import com.lisi.booknavigator.searchservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final ElasticsearchService elasticsearchService;
    private final OpenAiService openAiService;

    @Autowired
    public SearchService(OpenAiService openAiService, ElasticsearchService elasticsearchService) {
        this.openAiService = openAiService;
        this.elasticsearchService = elasticsearchService;
    }

    public List<Product> performSearch(String userInput) {
        String processedQuery = openAiService.processQuery(userInput);
        return elasticsearchService.search(processedQuery);
    }
}
