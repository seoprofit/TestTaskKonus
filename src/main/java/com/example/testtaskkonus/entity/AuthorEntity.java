package com.example.testtaskkonus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;


import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "books_and_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName="id"))
    private List<BookEntity> authorBooks;


}
