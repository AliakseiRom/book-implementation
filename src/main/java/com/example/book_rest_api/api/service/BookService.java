package com.example.book_rest_api.api.service;


import com.example.book_rest_api.api.model.Book;
import com.example.book_rest_api.api.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {

    public BookService() {
    }

    public static ResponseEntity<Book> getBook(Integer id, BookRepository bookRepository) {
        Optional<Book> bookData = bookRepository.findById(id);
        return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
    }

    public static ResponseEntity<Book> createBook(Book book, BookRepository bookRepository) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    public static ResponseEntity<Book> updateBook(Integer id, BookRepository bookRepository, Book book) {
        Optional<Book> bookData = bookRepository.findById(id);

        Book savedBook = bookData.get();
        savedBook.setTitle(book.getTitle());
        savedBook.setAuthor(book.getAuthor());
        savedBook.setId(id);

        return new ResponseEntity<>(bookRepository.save(savedBook), HttpStatus.OK);
    }

    public static ResponseEntity<Book> deleteBook(Integer id, BookRepository bookRepository) {
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<Book> deleteAllBooks(BookRepository bookRepository) {
        bookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
