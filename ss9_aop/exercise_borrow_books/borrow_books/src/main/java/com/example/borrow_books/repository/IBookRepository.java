package com.example.borrow_books.repository;

import com.example.borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from book", nativeQuery = true)
    Page<Book> findAllBook(String name, Pageable pageable);
}
