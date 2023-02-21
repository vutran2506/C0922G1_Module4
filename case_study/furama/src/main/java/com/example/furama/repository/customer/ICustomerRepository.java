package com.example.furama.repository.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page <Customer> findAll(Pageable pageable);
//    @Query(value = "select * from Customer where name like concat('%',:name,'%') and email" +
//            " like concat('%',:searchEmail,'%')" +
//            " and customer_type =:customerType", nativeQuery = true)
//    Page<Customer> search( @Param("name") String name,@Param("searchEmail") String email,@Param("customerType") int customerType,Pageable pageable);


    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int customerTypeId, Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContaining(String name, String email,  Pageable pageable);

}
