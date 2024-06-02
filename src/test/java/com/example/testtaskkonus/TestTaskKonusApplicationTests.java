package com.example.testtaskkonus;

import com.example.testtaskkonus.entity.AuthorEntity;
import com.example.testtaskkonus.entity.BookEntity;
import com.example.testtaskkonus.repository.AuthorRepository;
import com.example.testtaskkonus.repository.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestTaskKonusApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    public void addBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Book 1");
        bookEntity.setISBN(1242141);
        bookRepository.save(bookEntity);

    }

    @BeforeEach
    public void addAuthor() {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("Book 1");
        authorRepository.save(authorEntity);

    }


    @Test
    public void getAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].ID").isNotEmpty());
    }

    @Test
    public void getAllAuthors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/authors")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].ID").isNotEmpty());
    }


}
