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
@Table(name = "Author")
public class AuthorEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Name")
    private String name;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<BookEntity> authorBooks;


}
