package com.example.exercise_optional.service;


import com.example.exercise_optional.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void  delete(int id);
    Optional findById(int id);
    Page<Blog> findByNam(String name, Pageable pageable);
    Page<Blog> findByCategory_Id(int id, Pageable pageable);
}
