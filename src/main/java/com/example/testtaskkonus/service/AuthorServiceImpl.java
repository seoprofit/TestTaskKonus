package com.example.testtaskkonus.service;

import com.example.testtaskkonus.DTO.*;
import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;


    public List<AuthorWithBooks> getAllAuthors() {
        List <AuthorEntity> allAuthors = new ArrayList<>();
        List <AuthorWithBooks> allAuthorsWithBooks = new ArrayList<>();

        allAuthors.addAll(this.authorRepository.findAll());
        for (AuthorEntity authorEntity: allAuthors) {
            allAuthorsWithBooks.add(AuthorWithBooks.fromModel(authorEntity));
        }
        return allAuthorsWithBooks;
    }

    @Override
    public void createAuthor(SaveAuthor author) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        this.authorRepository.save(authorEntity);
    }

    @Override
    public void updateAuthor(UUID id, UpdateAuthor updateAuthor) {

        if (authorRepository.findById(id).isPresent()) {
            AuthorEntity authorEntity = this.authorRepository.findById(id).orElse(new AuthorEntity());
            authorEntity.setAuthorBooks(updateAuthor.getAuthorBooks());
            authorEntity.setName(updateAuthor.getName());
            this.authorRepository.save(authorEntity);
        } else {
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setAuthorBooks(updateAuthor.getAuthorBooks());
            authorEntity.setName(updateAuthor.getName());
            this.authorRepository.save(authorEntity);
        }

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

