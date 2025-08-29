package com.vkoryakin.junit.Controller;

import com.vkoryakin.junit.Entity.Book;
import com.vkoryakin.junit.Repository.BookRepository;
import com.vkoryakin.junit.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    BookService bookService;

    @GetMapping("/")
    ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }
@GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateById(@PathVariable long id, @RequestBody Book book) {
        return bookRepository.findById(id)
                .map(exist -> {
                  if (book.getTitle()!=null) {
                      exist.setTitle(book.getTitle());
                  }
                   return ResponseEntity.ok( bookRepository.save(exist));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}




