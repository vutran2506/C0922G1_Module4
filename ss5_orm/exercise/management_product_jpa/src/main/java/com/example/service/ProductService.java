package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByNam(String name) {
        return productRepository.findByNam(name);
    }
}
