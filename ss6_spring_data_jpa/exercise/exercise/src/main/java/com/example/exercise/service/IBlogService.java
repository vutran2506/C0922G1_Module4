package com.example.exercise.service;

import com.example.exercise.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void  edit(Blog blog);
    void  delete(int id);
    Optional findById(int id);
}
