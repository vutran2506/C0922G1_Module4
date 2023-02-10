package com.example.exercise_optional.service;

import com.example.exercise_optional.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void  delete(int id);
    Category findById(int id);

}
