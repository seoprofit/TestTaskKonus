package com.example.testtaskkonus.rest;

import com.example.testtaskkonus.DTO.Author;
import com.example.testtaskkonus.DTO.Book;
import com.example.testtaskkonus.DTO.SaveBook;
import com.example.testtaskkonus.DTO.UpdateBook;
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
    public List<BookEntity> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("add")
    public ResponseEntity<Book> addBook(@RequestBody SaveBook saveBook) {
        this.bookService.createBook(saveBook);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("update")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBook updateBook) {
        this.bookService.updateBook(updateBook);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
        Optional<BookEntity> book = this.bookService.getBookById(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable UUID id) {
        this.bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
