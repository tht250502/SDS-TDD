package org.example.BookStore;

import org.example.BookStore.model.User;
import org.example.BookStore.repository.UserRepository;
import org.example.BookStore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void should_return_true_when_login_successful() {
        User user = User.builder()
                .username("admin")
                .password("admin333")
                .email("example@mail.com")
                .address("Ha Noi")
                .fullName("Admin Name")
                .phone("0123456789")
                .build();
        when(userRepository.findUserByUserNameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);

        User loginUser = userService.login("admin", "admin333");
        assertNotNull(loginUser);
        assertEquals("admin", loginUser.getUsername());
        verify(userRepository, times(1)).findUserByUserNameAndPassword(anyString(), anyString());
    }

    @ParameterizedTest
    @CsvSource({
    "admin, wrongpassword", "wronguser, admin", "wronguser, wrong", "admin, ''", "admin, '   '", "'', ''", "'   ', '   '", "'', admin", "'   ', admin"})
    public void should_throw_exception_when_login_unsuccessful(String username, String password) {
        when(userRepository.findUserByUserNameAndPassword(username, password)).thenReturn(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.login(username, password));
        assertEquals("Invalid username or password", exception.getMessage());
        verify(userRepository, times(1)).findUserByUserNameAndPassword(username, password);
    }
}
