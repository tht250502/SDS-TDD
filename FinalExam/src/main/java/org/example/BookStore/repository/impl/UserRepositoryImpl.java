package org.example.BookStore.repository.impl;

import org.example.BookStore.model.User;
import org.example.BookStore.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        return null;
    }
}
