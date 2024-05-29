package com.example.testtaskkonus.service;


import com.example.testtaskkonus.DTO.SaveBook;
import com.example.testtaskkonus.DTO.UpdateBook;
import com.example.testtaskkonus.entity.BookEntity;
import com.example.testtaskkonus.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;


    @Override
    public List<BookEntity> getAllBooks() {
        return this.bookRepository.findAll();
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
    public void updateBook(UpdateBook updateBook) {
        BookEntity bookEntity = this.bookRepository.findById(UUID.fromString((String.valueOf((updateBook.getId()))))).orElse(new BookEntity());
        bookEntity.setId(updateBook.getId());
        bookEntity.setISBN(updateBook.getISBN());
        bookEntity.setName(updateBook.getName());
        this.bookRepository.save(bookEntity);


    }

    @Override
    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);
    }
}
