package com.example.managementphone.service;

import com.example.managementphone.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();
    Optional<SmartPhone> findById(Long id);
    SmartPhone save(SmartPhone smartPhone);
    void remove(long id);
}
