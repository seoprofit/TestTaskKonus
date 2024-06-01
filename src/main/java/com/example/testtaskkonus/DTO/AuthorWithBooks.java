package com.example.testtaskkonus.DTO;

import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AuthorWithBooks {

    @JsonProperty("ID")
    private UUID id;
    @JsonProperty ("Author name")
    private String name;
    @JsonProperty ("Author's books'")
    private List<Book> authorBooks;



    public static AuthorWithBooks fromModel (AuthorEntity authorEntity)
    {
        AuthorWithBooks authorWithBooks = new AuthorWithBooks();
        authorWithBooks.setName(authorEntity.getName());
        authorWithBooks.setId(authorEntity.getId());
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity: authorEntity.getAuthorBooks())
        {
            books.add(Book.fromModel(bookEntity));
        }
        authorWithBooks.setAuthorBooks(books);

        return authorWithBooks;
    }

}
