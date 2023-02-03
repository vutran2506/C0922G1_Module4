package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void create(Product product);
    void edit(int id, Product product);
    void remove(int id);
    Product findById (int id);
    Product findByName(String name);
}
