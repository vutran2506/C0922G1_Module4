package com.example.exercise_optional.repository;

import com.example.exercise_optional.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String name, Pageable pageable);
  Page<Blog> findByCategory_Id(int id, Pageable pageable);
}
