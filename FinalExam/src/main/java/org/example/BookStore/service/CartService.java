package org.example.BookStore.service;

import org.example.BookStore.model.Cart;
import org.example.BookStore.model.CartItem;
import org.example.BookStore.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemService cartItemService;

    public CartService(CartRepository cartRepository, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
    }

    public boolean addToCart(Long userId, Long bookId, int quantity) {
        Cart cart = cartRepository.findCartByUserId(userId);
        if(cart == null) {
            cart = cartRepository.createCart(userId);
        }

        CartItem cartItem = CartItem.builder()
                .bookId(bookId)
                .quantity(quantity)
                .cartId(cart.getId())
                .build();
        return cartItemService.addItemToCart(cartItem);
    }

    public boolean deleteItemFromCart(Long userId, Long bookId) {
        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart == null) {
            return false;
        }
        return cartItemService.deleteItemFromCart(cart.getId(), bookId);
    }


}
