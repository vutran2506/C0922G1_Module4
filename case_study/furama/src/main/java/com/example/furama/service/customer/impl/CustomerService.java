package com.example.furama.service.customer.impl;

import com.example.furama.model.customer.Customer;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> searchCustomer(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType_Id(name, email, customerTypeId, pageable);
    }

    @Override
    public Page<Customer> searchCustomerNameAndEmail(String name, String email, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
