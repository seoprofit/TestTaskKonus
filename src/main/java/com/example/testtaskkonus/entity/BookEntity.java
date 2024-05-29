package com.example.testtaskkonus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Name")
    private String name;
    @Column(name = "ISBN")
    private Integer ISBN;
    @ManyToMany
    private List<AuthorEntity> bookAuthor;


}
