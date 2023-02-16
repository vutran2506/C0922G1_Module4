package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    // Xem các Category
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    // Xem các Blog của 1 category
    @GetMapping("/category/{id}")
    public ResponseEntity<Set<Blog>> getCategoryById(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category.getBlogSet().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category.getBlogSet() ,HttpStatus.OK);
    }
}
