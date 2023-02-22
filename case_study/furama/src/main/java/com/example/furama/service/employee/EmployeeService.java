package com.example.furama.service.employee;

import com.example.furama.model.employee.Employee;
import com.example.furama.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements  IEmployeeService{

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).get();
    }
}
