package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAllBook(String name, Pageable pageable) {
        return bookRepository.findAllBook(name, pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
