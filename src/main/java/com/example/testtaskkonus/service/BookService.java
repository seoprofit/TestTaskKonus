package com.example.testtaskkonus.service;


import com.example.testtaskkonus.DTO.BookWithAuthor;
import com.example.testtaskkonus.DTO.SaveBook;
import com.example.testtaskkonus.DTO.UpdateBook;
import com.example.testtaskkonus.entity.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<BookWithAuthor> getAllBooks();

    Optional<BookEntity> getBookById(UUID id);

    void createBook(SaveBook saveBook);

    void updateBook(UUID id, UpdateBook updateBook);

    void deleteBook(UUID id);
}
