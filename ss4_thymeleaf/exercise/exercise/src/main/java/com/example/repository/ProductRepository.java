package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "bike", 1000.0, "new", "chinese"));
        productList.put(4, new Product(4, "bike", 1000.0, "new", "chineses"));
        productList.put(2, new Product(2, "car", 10000.0, "new", "vietnamese"));
        productList.put(3, new Product(3, "motoBike", 5000.0, "new", "Japanese"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void edit(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        for (Product product: productList.values()){
            if (product.getName().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product: productList.values()){
            if (product.getName().equals(name)){
                productList1.add(product);
            }
        }
        return productList1;
    }
}
