package com.example.exersice.repository;


import com.example.exersice.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
Page<Blog> findByNameContaining(String name, Pageable pageable);
}
