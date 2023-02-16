package com.example.exersice.service.impl;



import com.example.exersice.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void  delete(int id);
    Blog findById(int id);
Page<Blog> findByName(String name, Pageable pageable);
}
