package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public interface IBookService {

    Page<Book> findAllBook(String name, Pageable pageable);
    Book findById(int id);
    void save(Book book);
}
