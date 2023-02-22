package com.example.exercise_optional.service;


import com.example.exercise_optional.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    void save(Blog blog);
    void  delete(int id);
    Blog findById(int id);
    Page<Blog> findByName(String name, Pageable pageable);
    Page<Blog> findByCategory_IdAndName( String name,int id, Pageable pageable);

}
