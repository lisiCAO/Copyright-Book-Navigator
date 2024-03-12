package com.lisi.booknavigator.searchservice.controller;

import com.lisi.booknavigator.searchservice.Dto.SearchResponse;
import com.lisi.booknavigator.searchservice.entity.Product;
import com.lisi.booknavigator.searchservice.service.SearchService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam @NotBlank String query){
        List<Product> results = searchService.performSearch(query);
        List<SearchResponse> responses = results.stream()
                .map(product -> new SearchResponse(product.getName(), product.getDescription()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
