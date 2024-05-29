package com.example.testtaskkonus.DTO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private UUID id;
    private String name;
    private List<Book> authorBook;
}
