package com.lisi.booknavigator.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        // TODO: send out an email notification
        log.info("Received Notification for Order {}", orderPlacedEvent.getOrderNumber());
    }

    @KafkaListener(topics = "productsTopic", groupId = "search-service-group")
    public void handleProductEvent(ProductEvent event) {
        switch (event.getEventType()) {
            case CREATE:
            case UPDATE:
                sendNotification(event.getProduct());
                break;
            case DELETE:
                sendDeleteNotification(event.getProductId());
                break;
        }
    }

    private void sendNotification(Product product) {
        // TODO: create logic
    }

    private void sendDeleteNotification(String productId) {
        // TODO: delete logic
    }
}
