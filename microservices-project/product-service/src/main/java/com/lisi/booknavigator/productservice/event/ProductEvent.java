package com.lisi.booknavigator.productservice.event;

import com.lisi.booknavigator.productservice.model.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEvent {
    private String productId;
    private EventType eventType;
    private Product product;

    public enum EventType {
        CREATE, UPDATE, DELETE
    }
}
