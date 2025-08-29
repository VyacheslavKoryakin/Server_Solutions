package com.vkoryakin.junit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.vkoryakin.junit.Entity.Book;
import com.vkoryakin.junit.Repository.BookRepository;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    Faker faker;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    Random rand = new Random();

    @Test
    @Order(7)
    public void create_book_insert_return_book() throws Exception {
        String title = "Book title";
        String author = "Koryakin";
        int year = 2025;

        Book book = new Book(title, author, year);
        bookRepository.save(book);
        mockMvc.perform(post("/api/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(title)))
                .andExpect(jsonPath("$.author", is(author)))
                .andExpect(jsonPath("$.year", is(year)));


    }

    @Test
    @Order(2)
    public void get_book_existing_id_return_book() throws Exception {
        String title = "Book title";
        String author = "Koryakin";
        int year = 2025;
        Book book = new Book(title, author, year);

        var result = bookRepository.save(book);
        mockMvc.perform(get("/api/{id}", result.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.year", is(book.getYear())))
                .andExpect(jsonPath("$.id").value(book.getId()));

    }

    @Test
    @Order(3)
    public void get_book_nonexisting_id_return_not_found() throws Exception {
        mockMvc.perform(get("/api/{id}", -1))
                .andExpect(status().isNotFound());


    }

    private void add_100_books() throws Exception {
        if (bookRepository.count() < 100) {
            List<Book> books = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                books.add(new Book(faker.book().title(), faker.book().author(), faker.number().numberBetween(1950, 2025)));
            }
            bookRepository.saveAll(books);
        }
    }

    @Test
    @Order(6)
    public void get_All_book_return_All_books() throws Exception {
        add_100_books();
        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(100))));


    }

    @Test
    @Order(1)
    public void get_empty_book_return_not_content() throws Exception {
        bookRepository.deleteAll();
        mockMvc.perform(get("/api/"))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    public void delete_books_ruturn_Id_return_ok() throws Exception {
        String title = "Book title";
        String author = "Koryakin";
        int year = 2025;

        Book book = new Book(title, author, year);
        bookRepository.save(book);
        mockMvc.perform(delete("/api/{id}", book.getId()))
                .andExpect(status().isOk());


    }

    @Test
    @Order(6)
    public void delete_books_not_exist_id_return_not_found() throws Exception {
        String title = "Book title";
        String author = "Koryakin";
        int year = 2025;

        Book book = new Book(title, author, year);
        bookRepository.save(book);
        mockMvc.perform(delete("/api/{id}", -1))
                .andExpect(status().isNotFound());
    }

    @BeforeEach
    public  void testBegin() throws Exception {
        System.out.println("\n----------------------------------");
        System.out.println("Begin  test");
        System.out.println("\n----------------------------------");



    }

    @AfterEach
    public  void testFinish() throws Exception {
        System.out.println("\n----------------------------------");
        System.out.println("Finish  test");
        System.out.println("\n----------------------------------");



    }
    @AfterAll
    public static void testEnd() throws Exception {
        System.out.println("\n----------------------------------");
        System.out.println("All tests are done");
        System.out.println("\n----------------------------------");
    }
}

