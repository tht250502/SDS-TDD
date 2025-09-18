package org.example.BookStore.repository;

import org.example.BookStore.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    User findUserByUserNameAndPassword(String username, String password);
}
