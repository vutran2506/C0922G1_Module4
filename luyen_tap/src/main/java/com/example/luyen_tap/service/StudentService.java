package com.example.luyen_tap.service;

import com.example.luyen_tap.model.Student;
import com.example.luyen_tap.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(studentRepository.findById(id).get());
    }

    @Override
    public Student findByiId(int id) {
        return studentRepository.findById(id).get();
    }
}
