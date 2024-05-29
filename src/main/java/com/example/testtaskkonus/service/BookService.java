package com.example.testtaskkonus.service;


import com.example.testtaskkonus.DTO.SaveBook;
import com.example.testtaskkonus.DTO.UpdateBook;
import com.example.testtaskkonus.entity.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<BookEntity> getAllBooks();

    Optional<BookEntity> getBookById(UUID id);

    void createBook(SaveBook saveBook);

    void updateBook(UpdateBook updateBook);

    void deleteBook(UUID id);
}
