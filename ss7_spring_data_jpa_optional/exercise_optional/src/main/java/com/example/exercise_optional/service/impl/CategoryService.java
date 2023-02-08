package com.example.exercise_optional.service.impl;

import com.example.exercise_optional.model.Category;
import com.example.exercise_optional.repository.ICategoryRepository;
import com.example.exercise_optional.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {

        categoryRepository.delete(categoryRepository.findById(id).get());
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }
}
