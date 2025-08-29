package com.vkoryakin.junit.Service;

import com.vkoryakin.junit.Entity.Book;
import com.vkoryakin.junit.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<List<Book>> getBooks() {
     return (ResponseEntity) bookRepository.findAll();
    }
}
