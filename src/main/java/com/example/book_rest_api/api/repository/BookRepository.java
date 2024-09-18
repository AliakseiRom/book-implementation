package com.example.book_rest_api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book_rest_api.api.model.Book;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    Optional<Book> findById(int id);

    List<Book> findBooksByAuthor(String author);
}
