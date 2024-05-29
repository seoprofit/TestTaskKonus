package com.example.testtaskkonus.repository;

import com.example.testtaskkonus.DTO.Author;
import com.example.testtaskkonus.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository  extends JpaRepository<AuthorEntity, UUID> {
}
