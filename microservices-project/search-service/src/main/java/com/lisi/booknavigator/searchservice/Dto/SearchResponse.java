package com.lisi.booknavigator.searchservice.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResponse {
    private String name;
    private String description;
}
