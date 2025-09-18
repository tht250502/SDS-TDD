package org.example.BookStore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String address;
    private String phone;
}
