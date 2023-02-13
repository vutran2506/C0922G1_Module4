package com.example.luyen_tap.repository;

import com.example.luyen_tap.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
