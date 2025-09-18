package org.example.BookStore.database;

import org.example.BookStore.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    public static final List<User> users = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
    public static final List<CartItem> cartItems = new ArrayList<>();
    public static final List<Cart> carts = new ArrayList<>();
    public static final List<Book> books = new ArrayList<>();

    static {
        setupUsers();
        setupBooks();
    }

    private static void setupBooks() {
        books.add(Book.builder().id(1L).title("Refactoring").author("Martin Fowler").price(590.0).build());
        books.add(Book.builder().id(2L).title("The Pragmatic Programmer").author("Andrew Hunt & David Thomas").price(620.0).build());
        books.add(Book.builder().id(3L).title("Structure and Interpretation of Computer Programs").author("Harold Abelson").price(780.0).build());
        books.add(Book.builder().id(4L).title("Effective Java").author("Joshua Bloch").price(600.0).build());
        books.add(Book.builder().id(5L).title("Cracking the Coding Interview").author("Gayle Laakmann McDowell").price(670.0).build());
        books.add(Book.builder().id(6L).title("The Clean Coder").author("Robert C. Martin").price(490.0).build());
        books.add(Book.builder().id(7L).title("Grokking Algorithms").author("Aditya Bhargava").price(460.0).build());
        books.add(Book.builder().id(8L).title("Don't Make Me Think").author("Steve Krug").price(400.0).build());
    }

    private static void setupUsers() {
        users.add(User.builder()
                .id(1L).username("linda01").password("password01").email("linda@mail.com")
                .address("Bắc Ninh, Việt Nam").fullName("Linda Phạm").phone("0901234567").build());

        users.add(User.builder()
                .id(2L).username("mike02").password("password02").email("mike@mail.com")
                .address("Thanh Hóa, Việt Nam").fullName("Mike Trịnh").phone("0912345679").build());

        users.add(User.builder()
                .id(3L).username("nina03").password("password03").email("nina@mail.com")
                .address("Nam Định, Việt Nam").fullName("Nina Vương").phone("0923456780").build());

        users.add(User.builder()
                .id(4L).username("oscar04").password("password04").email("oscar@mail.com")
                .address("Bình Dương, Việt Nam").fullName("Oscar Hoàng").phone("0934567891").build());

        users.add(User.builder()
                .id(5L).username("paula05").password("password05").email("paula@mail.com")
                .address("Long An, Việt Nam").fullName("Paula Lâm").phone("0945678902").build());
    }
}
