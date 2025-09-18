package org.example.BookStore.service;

import org.example.BookStore.model.CartItem;
import org.example.BookStore.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public boolean addItemToCart(CartItem cartItem) {
        CartItem saved = cartItemRepository.save(cartItem);
        return saved != null;
    }

    public boolean deleteItemFromCart(Long userId, Long bookId) {
        cartItemRepository.deleteByUserIdAndBookId(userId, bookId);
        return true;
    }
}
