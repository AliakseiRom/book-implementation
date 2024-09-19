package com.example.book_rest_api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book_rest_api.api.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
