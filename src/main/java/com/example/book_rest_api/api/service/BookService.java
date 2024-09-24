package com.example.book_rest_api.api.service;

import com.example.book_rest_api.api.model.Book;
import com.example.book_rest_api.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book getBook(Integer id) {
        try {
            Optional<Book> savedBook = bookRepository.findById(id);
            Book book = savedBook.get();
            return book;
        } catch (Exception e) {
            return null;
        }
    }

    public Book createBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public Book updateBook(Integer id, Book book) {
        Optional<Book> bookData;
        try {
            bookData = bookRepository.findById(id);
        } catch (Exception e) {
            return null;
        }


        Book savedBook = bookData.get();
        savedBook.setTitle(book.getTitle());
        savedBook.setAuthor(book.getAuthor());
        savedBook.setId(id);

        return savedBook;
    }

    public Book deleteBook(Integer id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public Book deleteAllBooks() {
        bookRepository.deleteAll();
        return null;
    }
}
