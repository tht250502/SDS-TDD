package org.example.BookStore;

import org.assertj.core.api.Assertions;
import org.example.BookStore.model.Order;
import org.example.BookStore.model.enums.OrderStatus;
import org.example.BookStore.repository.OrderRepository;
import org.example.BookStore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void should_create_order_when_user_logged_in() {
        Order order = Order.builder()
                .userId(1L)
                .orderStatus(OrderStatus.PENDING)
                .build();

        when(orderRepository.save(order)).thenReturn(order);

        boolean result = orderService.createOrder(order);
        assertTrue(result);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void should_throw_exception_when_user_not_logged_in() {
        Order order = Order.builder().build();
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            orderService.createOrder(order);
        });
        assertEquals("User must be logged in to place an order", ex.getMessage());
        verify(orderRepository, never()).save(any());
    }

    @Test
    public void should_return_true_when_cancel_order_successfully() {
        Long orderId = 1L;
        Order order = Order.builder()
                .id(1L)
                .userId(1L)
                .orderStatus(OrderStatus.CANCELLED)
                .build();

        when(orderRepository.findById(orderId)).thenReturn(order);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        boolean result = orderService.cancelOrder(orderId);

        Assertions.assertThat(result).isTrue();

        verify(orderRepository, times(1)).findById(orderId);
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}
