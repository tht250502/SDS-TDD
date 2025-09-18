package org.example.BookStore.service;

import org.example.BookStore.model.User;
import org.example.BookStore.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        User user = userRepository.findUserByUserNameAndPassword(username, password);
        if(user == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return user;
    }
}

