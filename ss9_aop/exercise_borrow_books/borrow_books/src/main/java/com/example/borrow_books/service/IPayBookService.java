package com.example.borrow_books.service;

import com.example.borrow_books.model.PayBook;


public interface IPayBookService {

    void save(PayBook payBook);
    void delete(PayBook payBook);
    PayBook findByCode(int code);
}
