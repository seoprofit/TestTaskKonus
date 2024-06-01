package com.example.testtaskkonus.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;


import java.util.List;
import java.util.UUID;

@Data
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
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)

    private List<BookEntity> authorBooks;


}
