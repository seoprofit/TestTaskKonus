package com.example.testtaskkonus.rest;

import com.example.testtaskkonus.DTO.*;
import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.example.testtaskkonus.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public List<BookWithAuthor> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("add")
    public ResponseEntity<Book> addBook(@RequestBody SaveBook saveBook) {
        this.bookService.createBook(saveBook);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable UUID id, @RequestBody UpdateBook updateBook) {
        this.bookService.updateBook(id, updateBook);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<BookWithAuthor> getBookById(@PathVariable UUID id) {
        Optional<BookEntity> book = this.bookService.getBookById(id);
        BookWithAuthor bookWithAuthor = new BookWithAuthor().fromModel(book.get());
        return new ResponseEntity(bookWithAuthor, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable UUID id) {
        this.bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
