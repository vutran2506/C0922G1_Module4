package com.example.exercise.repository;

import com.example.exercise.entity.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
