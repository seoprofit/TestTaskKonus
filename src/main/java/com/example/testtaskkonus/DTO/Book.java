package com.example.testtaskkonus.DTO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private UUID id;
    private String name;
    private Integer ISBN;


}
