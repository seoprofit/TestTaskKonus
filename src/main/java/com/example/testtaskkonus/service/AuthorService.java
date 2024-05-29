package com.example.testtaskkonus.service;

import com.example.testtaskkonus.DTO.SaveAuthor;
import com.example.testtaskkonus.DTO.UpdateAuthor;
import com.example.testtaskkonus.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
    List<AuthorEntity> getAllAuthors();

    void createAuthor(SaveAuthor author);

    void updateAuthor(UpdateAuthor author);

    void deleteAuthor(UUID id);

    Optional<AuthorEntity> getAuthorById(UUID id);
}
