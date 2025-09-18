package org.example.BookStore.repository.impl;

import org.example.BookStore.model.Order;
import org.example.BookStore.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final Map<Long, Order> storage = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(idGenerator.getAndIncrement());
        }
        storage.put(order.getId(), order);
        return order;
    }

    @Override
    public Order findById(Long orderId) {
        return null;
    }
}
