package com.example.exercise_optional.repository;

import com.example.exercise_optional.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String name, Pageable pageable);
//    Query thuần
//    @Query(value = "select * from blog where blog_id = :id",nativeQuery = true)
//    Page<Blog> search(@Param("id") int id, Pageable pageable);
  Page<Blog> findByNameContainingAndAndCategory_Id( String name, int id, Pageable pageable);
}
