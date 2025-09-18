package org.example.BookStore.repository;

import org.example.BookStore.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    Cart findCartByUserId(Long id);
    Cart createCart(Long userId);
}