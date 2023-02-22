package com.example.furama.service.employee;

import com.example.furama.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
}
