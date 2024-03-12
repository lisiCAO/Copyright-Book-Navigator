package com.lisi.booknavigator.notificationservice;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    private String productId;
    private EventType eventType;
    private Product product;

    public enum EventType {
        CREATE, UPDATE, DELETE
    }
}
