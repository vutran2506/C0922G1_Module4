package com.example.furama.service.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> getAllCustomer(Pageable pageable);
    void save(Customer customer);
    Customer findById(int id);
    Page<Customer> searchCustomer(String name, String email, int customerTypeId, Pageable pageable);
    Page<Customer> searchCustomerNameAndEmail(String name, String email,  Pageable pageable);
    List<Customer> findAll();
}
