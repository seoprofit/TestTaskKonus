package com.example.testtaskkonus.rest;

import com.example.testtaskkonus.DTO.*;
import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping()
    public List<AuthorEntity> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    @PostMapping("add")
    public ResponseEntity<Author> addAuthor(@RequestBody SaveAuthor author) {
        this.authorService.createAuthor(author);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable UUID id) {
        Optional<AuthorEntity> book = this.authorService.getAuthorById(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }


    @PatchMapping("update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable UUID id, @RequestBody UpdateAuthor updateAuthor) {
        this.authorService.updateAuthor(id, updateAuthor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Author> deleteAuthorById(@PathVariable UUID id) {
        this.authorService.deleteAuthor(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}







