package com.lisi.booknavigator.searchservice.controller;

import com.lisi.booknavigator.searchservice.Dto.SearchResponse;
import com.lisi.booknavigator.searchservice.entity.Product;
import com.lisi.booknavigator.searchservice.service.SearchService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<?> search(@RequestParam @NotBlank String query){
        List<Product> results = searchService.performSearch(query);
        List<SearchResponse> responses = results.stream()
                .map(product -> new SearchResponse(product.getName(), product.getDescription()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
