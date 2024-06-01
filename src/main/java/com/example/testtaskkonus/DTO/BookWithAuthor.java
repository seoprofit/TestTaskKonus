package com.example.testtaskkonus.DTO;

import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BookWithAuthor {
    @JsonProperty ("ID")
    private UUID id;
    @JsonProperty ("Book name")
    private String name;
    @JsonProperty ("Book ISBN")
    private Integer ISBN;
    @JsonProperty ("Book's authors")
    private List<Author> bookAuthors;
    public static BookWithAuthor fromModel (BookEntity bookEntity)
    {
        BookWithAuthor bookWithAuthor = new BookWithAuthor();
        bookWithAuthor.setId(bookEntity.getId());
        bookWithAuthor.setName(bookEntity.getName());
        bookWithAuthor.setISBN(bookEntity.getISBN());
        List<Author> authors = new ArrayList<>();
        for (AuthorEntity authorEntity: bookEntity.getBookAuthors())
        {
            authors.add(Author.fromModel(authorEntity));
        }
        bookWithAuthor.setBookAuthors(authors);

        return bookWithAuthor;
    }

}
