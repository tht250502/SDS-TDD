package org.example.BookStore.repository.impl;

import org.example.BookStore.model.Cart;
import org.example.BookStore.repository.CartRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {
    @Override
    public Cart findCartByUserId(Long id) {
        return null;
    }

    @Override
    public Cart createCart(Long userId) {
        return null;
    }
}
