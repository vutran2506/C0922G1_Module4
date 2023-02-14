package com.example.shopping.service;

import com.example.shopping.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById( long id);
}
