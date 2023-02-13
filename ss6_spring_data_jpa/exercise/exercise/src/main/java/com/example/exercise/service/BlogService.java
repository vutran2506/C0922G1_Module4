package com.example.exercise.service;

import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private  IBlogRepository blogRepository;

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

        blogRepository.delete(blogRepository.findById(id).get());
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }
}
