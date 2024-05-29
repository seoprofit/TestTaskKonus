package com.example.testtaskkonus.repository;

import com.example.testtaskkonus.DTO.Book;
import com.example.testtaskkonus.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

}
