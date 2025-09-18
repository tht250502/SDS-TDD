package org.example.BookStore;

import org.assertj.core.api.Assertions;
import org.example.BookStore.model.CartItem;
import org.example.BookStore.repository.CartItemRepository;
import org.example.BookStore.service.CartItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartItemServiceTest {
    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemService cartItemService;

    @Test
    void should_return_true_when_add_item_to_cart_successfully() {
        CartItem cartItem = CartItem.builder()
                .bookId(1L)
                .quantity(3)
                .build();

        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        boolean result = cartItemService.addItemToCart(cartItem);

        Assertions.assertThat(result).isTrue();

        verify(cartItemRepository, times(1)).save(cartItem);
    }

    @Test
    void should_return_true_when_delete_item_from_cart_successfully() {
        Long userId = 1L;
        Long bookId = 1L;

        boolean result = cartItemService.deleteItemFromCart(userId, bookId);

        Assertions.assertThat(result).isTrue();

        verify(cartItemRepository, times(1)).deleteByUserIdAndBookId(userId, bookId);
    }

    @Test
    void should_return_false_when_add_item_fail() {
        CartItem cartItem = CartItem.builder()
                .bookId(2L)
                .quantity(1)
                .build();

        when(cartItemRepository.save(cartItem)).thenReturn(null);

        boolean result = cartItemService.addItemToCart(cartItem);

        Assertions.assertThat(result).isFalse();
        verify(cartItemRepository, times(1)).save(cartItem);
    }

    @Test
    void should_throw_exception_when_delete_fail() {
        Long userId = 1L;
        Long bookId = 999L;

        doThrow(new RuntimeException("Delete failed")).when(cartItemRepository).deleteByUserIdAndBookId(userId, bookId);

        Assertions.assertThatThrownBy(() -> cartItemService.deleteItemFromCart(userId, bookId))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Delete failed");

        verify(cartItemRepository, times(1)).deleteByUserIdAndBookId(userId, bookId);
    }
}
