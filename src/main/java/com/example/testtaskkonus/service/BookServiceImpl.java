package com.example.testtaskkonus.service;


import com.example.testtaskkonus.DTO.AuthorWithBooks;
import com.example.testtaskkonus.DTO.BookWithAuthor;
import com.example.testtaskkonus.DTO.SaveBook;
import com.example.testtaskkonus.DTO.UpdateBook;
import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.example.testtaskkonus.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;


    @Override
    public List<BookWithAuthor> getAllBooks() {
        return bookRepository.findAll().stream().map(BookWithAuthor::fromModel).collect(Collectors.toList());

    }

    public Optional<BookEntity> getBookById(UUID id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void createBook(SaveBook saveBook) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setISBN(saveBook.getISBN());
        bookEntity.setName(saveBook.getName());
        this.bookRepository.save(bookEntity);
    }

    @Override
    @Transactional
    public void updateBook(UUID id, UpdateBook updateBook) {
        BookEntity bookEntity = this.bookRepository.findById(id).orElse(new BookEntity());

        bookEntity.setBookAuthors(updateBook.getBookAuthors());
        bookEntity.setName(updateBook.getName());

        this.bookRepository.save(bookEntity);

    }

    @Override
    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);
    }
}
