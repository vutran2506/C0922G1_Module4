package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void create(Product product);
    void remove(int id);
    void update(Product product);
    Product findById(int id);
    List<Product> findByNam(String name);
}
