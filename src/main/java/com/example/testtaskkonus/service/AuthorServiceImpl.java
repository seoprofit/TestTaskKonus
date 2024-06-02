package com.example.testtaskkonus.service;

import com.example.testtaskkonus.DTO.*;
import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.example.testtaskkonus.repository.AuthorRepository;
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
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public List<AuthorWithBooks> getAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorWithBooks::fromModel).collect(Collectors.toList());
    }

    @Override
    public void createAuthor(SaveAuthor author) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        if (!author.getAuthorBooks().isEmpty()) {
            for (BookEntity authorBook : author.getAuthorBooks()) {
                bookRepository.save(authorBook);
                authorEntity.setAuthorBooks(author.getAuthorBooks());
            }

        }
        this.authorRepository.save(authorEntity);
    }

    @Override
    @Transactional
    public void updateAuthor(UUID id, UpdateAuthor updateAuthor) {
        AuthorEntity authorEntity = this.authorRepository.findById(id).orElse(new AuthorEntity());

        authorEntity.setAuthorBooks(updateAuthor.getAuthorBooks());
        authorEntity.setName(updateAuthor.getName());

        this.authorRepository.save(authorEntity);

    }

    @Override
    public void deleteAuthor(UUID id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(UUID id) {
        return this.authorRepository.findById(id);
    }


}

