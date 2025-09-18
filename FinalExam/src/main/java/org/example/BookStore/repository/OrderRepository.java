package org.example.BookStore.repository;

import org.example.BookStore.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    Order save(Order order);
    Order findById(Long orderId);
}
