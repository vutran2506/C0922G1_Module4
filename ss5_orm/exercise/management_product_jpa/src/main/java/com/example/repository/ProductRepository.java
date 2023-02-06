package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList;
        productList = entityManager.createQuery(" FROM  Product ").getResultList();
        return productList;
    }

    @Transactional
    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }
    @Transactional
    @Override
    public void remove(int id) {
        Product product1 = findById(id);
        entityManager.remove(product1);
    }
@Transactional
    @Override
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setBrand(product.getBrand());
        entityManager.merge(product1);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByNam(String name) {
        List<Product>productList1;
        productList1 = entityManager.createQuery("select p from Product p where p.name like :name").setParameter("name","%"+name+"%").getResultList();
        return productList1;
    }
}
