package com.example.luyen_tap.service;

import com.example.luyen_tap.model.Student;


import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int id);
    Student findByiId(int id);
}
