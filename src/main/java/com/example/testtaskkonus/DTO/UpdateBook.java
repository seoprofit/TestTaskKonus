package com.example.testtaskkonus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBook {

    private UUID id;
    private String name;
    private Integer ISBN;


}
