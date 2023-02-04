package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save (Customer customer);
    void updateCustomer(int id, Customer customer);
    void removeCustomer(int id);
    Customer findByIdCustomer(int id);
}
