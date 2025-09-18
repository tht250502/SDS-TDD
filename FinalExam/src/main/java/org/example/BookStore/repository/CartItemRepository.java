package org.example.BookStore.repository;

import org.example.BookStore.model.CartItem;

public interface CartItemRepository {
    CartItem save(CartItem cartItem);
    void deleteByUserIdAndBookId(Long userId, Long bookId);
}
