package org.example.BookStore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Long id;
    private Long cartId;
    private Long bookId;
    private int quantity;
}
