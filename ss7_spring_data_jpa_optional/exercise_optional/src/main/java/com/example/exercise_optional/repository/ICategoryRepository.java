package com.example.exercise_optional.repository;

import com.example.exercise_optional.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
