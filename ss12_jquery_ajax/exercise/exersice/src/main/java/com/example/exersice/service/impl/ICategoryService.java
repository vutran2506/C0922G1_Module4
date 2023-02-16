package com.example.exersice.service.impl;



import com.example.exersice.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void  delete(int id);
    Category findById(int id);

}
