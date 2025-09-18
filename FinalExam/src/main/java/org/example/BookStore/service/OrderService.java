package org.example.BookStore.service;

import java.util.Optional;

import org.example.BookStore.model.Order;
import org.example.BookStore.model.enums.OrderStatus;
import org.example.BookStore.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean createOrder(Order order) {
        if (order == null || order.getUserId() == null) {
            throw new IllegalStateException("User must be logged in to place an order");
        }
        order.setOrderStatus(OrderStatus.PENDING);
        orderRepository.save(order);
        return true;
    }

    public boolean cancelOrder(Long orderId) {
        Optional<Order> optionalOrder = Optional.ofNullable(orderRepository.findById(orderId));
        if (optionalOrder.isEmpty()) {
            return false;
        }

        Order order = optionalOrder.get();
        order.setOrderStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
        return true;
    }
}
