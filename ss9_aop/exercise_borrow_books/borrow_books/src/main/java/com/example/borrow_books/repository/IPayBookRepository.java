package com.example.borrow_books.repository;

import com.example.borrow_books.model.PayBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPayBookRepository extends JpaRepository<PayBook,Integer> {
PayBook findByCode(int code);
}
