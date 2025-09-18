package org.example.BookStore.repository.impl;

import org.example.BookStore.model.CartItem;
import org.example.BookStore.repository.CartItemRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemRepositoryImpl implements CartItemRepository {
    @Override
    public CartItem save(CartItem cartItem) {
        return null;
    }

    @Override
    public void deleteByUserIdAndBookId(Long userId, Long bookId) {
    }
}
