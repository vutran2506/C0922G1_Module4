package com.example.exercise.service;


import com.example.exercise.model.Blog;


import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void  delete(int id);
    Blog findById(int id);

}
