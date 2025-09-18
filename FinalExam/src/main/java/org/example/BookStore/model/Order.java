package org.example.BookStore.model;

import lombok.Builder;
import lombok.Data;
import org.example.BookStore.model.enums.OrderStatus;

@Data
@Builder
public class Order {
    private Long id;
    private Long userId;
    private OrderStatus orderStatus;
}
