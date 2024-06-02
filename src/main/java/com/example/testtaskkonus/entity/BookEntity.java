package com.example.testtaskkonus.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")

    private String name;
    @Column(name = "isbn")

    private Integer ISBN;

    @ManyToMany (mappedBy = "authorBooks")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)

    private List<AuthorEntity> bookAuthors;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN=" + ISBN +
                ", bookAuthors=" + bookAuthors +
                '}';
    }
}
