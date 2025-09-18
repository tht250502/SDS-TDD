package org.example.BookStore;

import org.assertj.core.api.Assertions;
import org.example.BookStore.model.Cart;
import org.example.BookStore.model.CartItem;
import org.example.BookStore.repository.CartRepository;
import org.example.BookStore.service.CartItemService;
import org.example.BookStore.service.CartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    @Mock
    private CartRepository cartRepository;

    @Mock
    private CartItemService cartItemService;

    @InjectMocks
    private CartService cartService;

    @Test
    public void should_return_true_when_add_item_to_cart_successfully()
    {
        Cart cart = Cart.builder()
                .id(1L)
                .userId(1L)
                .build();

        CartItem cartItem = CartItem.builder()
                .bookId(1L)
                .quantity(5)
                .build();

        when(cartRepository.findCartByUserId(cart.getUserId())).thenReturn(null);
        when(cartRepository.createCart(cart.getUserId())).thenReturn(cart);
        when(cartItemService.addItemToCart(any())).thenReturn(true);

        boolean actual = cartService.addToCart(cart.getUserId(), cartItem.getBookId(), cartItem.getQuantity());

        Assertions.assertThat(actual).isTrue();
        verify(cartRepository, times(1)).createCart(any());
        verify(cartItemService, times(1)).addItemToCart(any());
    }

    @Test
    public void should_return_true_when_delete__item_from_cart_successfully() {
        Long userId = 1L;
        Long bookId = 1L;

        Cart cart = Cart.builder()
                .id(1L)
                .userId(userId)
                .build();

        when(cartRepository.findCartByUserId(userId)).thenReturn(cart);
        when(cartItemService.deleteItemFromCart(userId, bookId)).thenReturn(true);

        boolean actual = cartService.deleteItemFromCart(userId, bookId);

        Assertions.assertThat(actual).isTrue();
        verify(cartRepository, times(1)).findCartByUserId(eq(userId));
        verify(cartItemService, times(1)).deleteItemFromCart(eq(userId), eq(bookId));
    }

    @Test
    public void should_return_false_when_cart_cannot_be_delete() {
        Long userId = 1L;
        Long bookId = 1L;

        when(cartRepository.findCartByUserId(userId)).thenReturn(null);

        boolean actual = cartService.deleteItemFromCart(userId, bookId);
        Assertions.assertThat(actual).isFalse();

        verify(cartRepository, times(1)).findCartByUserId(eq(userId));
        verify(cartItemService, times(0)).deleteItemFromCart(any(), anyLong());
    }
}
