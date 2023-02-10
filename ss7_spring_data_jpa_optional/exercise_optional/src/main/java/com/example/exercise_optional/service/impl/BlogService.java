package com.example.exercise_optional.service.impl;


import com.example.exercise_optional.model.Blog;
import com.example.exercise_optional.repository.IBlogRepository;
import com.example.exercise_optional.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

        blogRepository.delete(blogRepository.findById(id).get());
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Page<Blog> findByNam(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findByCategory_Id(int id, Pageable pageable) {
        return blogRepository.findByCategory_Id(id, pageable);
    }


}
