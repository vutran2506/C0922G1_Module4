package com.example.borrow_books.service;

import com.example.borrow_books.model.PayBook;
import com.example.borrow_books.repository.IPayBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PayBookService implements IPayBookService{
    @Autowired
    private IPayBookRepository payBookRepository;

    @Override
    public void save(PayBook payBook) {
        payBookRepository.save(payBook);
    }

    @Override
    public void delete(PayBook payBook) {
        payBookRepository.delete(payBook);
    }

    @Override
    public PayBook findByCode(int code) {
        return payBookRepository.findByCode(code);
    }


}
