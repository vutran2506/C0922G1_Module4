package com.example.exercise.service.impl;


import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import com.example.exercise.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }
}
