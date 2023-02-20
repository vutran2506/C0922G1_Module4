package com.example.furama.model.customer;

import com.example.furama.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255,nullable = false)
    private String name;
    @Column(length = 255,nullable = false)
    private String dateOfBirth;
    @Column(nullable = false)
    private boolean gender;
    @Column(length = 255,nullable = false,unique = true)
    private String iDCard;
    @Column(length = 255,nullable = false,unique = true)
    private String phoneNumber;
    @Column(length = 255,nullable = false,unique = true)
    private String email;
    @Column(length = 255,nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    public Customer() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
