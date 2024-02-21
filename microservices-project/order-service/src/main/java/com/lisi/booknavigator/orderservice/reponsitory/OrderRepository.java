package com.lisi.booknavigator.orderservice.reponsitory;

import com.lisi.booknavigator.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
