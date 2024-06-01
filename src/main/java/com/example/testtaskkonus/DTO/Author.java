package com.example.testtaskkonus.DTO;


import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Author {

    private UUID id;
    private String name;



    public static Author fromModel (AuthorEntity authorEntity)
    {
        Author author = new Author();
        author.setId(authorEntity.getId());
        author.setName(authorEntity.getName());
        return author;
    }


}
