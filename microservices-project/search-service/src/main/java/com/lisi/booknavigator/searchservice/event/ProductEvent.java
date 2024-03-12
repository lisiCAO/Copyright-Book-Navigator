package com.lisi.booknavigator.searchservice.event;

import com.lisi.booknavigator.searchservice.entity.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProductEvent {

    private String productId;
    private EventType eventType;
    private Product product;

    public enum EventType {
        CREATE, UPDATE, DELETE
    }
}

