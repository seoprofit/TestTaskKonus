package com.example.testtaskkonus.DTO;

import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBook {

    private String name;
    private Integer ISBN;
    private List<AuthorEntity> bookAuthors;

}
