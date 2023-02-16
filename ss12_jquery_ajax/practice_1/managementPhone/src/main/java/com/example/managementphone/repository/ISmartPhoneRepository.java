package com.example.managementphone.repository;

import com.example.managementphone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
}
