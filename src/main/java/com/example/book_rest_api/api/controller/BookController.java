package com.example.book_rest_api.api.controller;


import com.example.book_rest_api.api.repository.BookRepository;
import com.example.book_rest_api.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.book_rest_api.api.model.Book;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
        return BookService.getBook(id, bookRepository);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return BookService.createBook(book, bookRepository);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        return BookService.updateBook(id, bookRepository, book);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
        return BookService.deleteBook(id, bookRepository);
    }

    @DeleteMapping(path = "/delete/all")
    public ResponseEntity<Book> deleteAllBooks() {
        return BookService.deleteAllBooks(bookRepository);
    }
}
