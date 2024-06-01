package com.example.testtaskkonus.DTO;


import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Book {

    private UUID id;
    private String name;
    private Integer ISBN;


    public static Book fromModel (BookEntity bookEntity)
    {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setName(bookEntity.getName());
        book.setISBN(bookEntity.getISBN());
        return book;
    }

}
