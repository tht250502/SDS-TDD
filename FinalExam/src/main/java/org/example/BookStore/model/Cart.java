package org.example.BookStore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {
    private Long id;
    private Long userId;
}
