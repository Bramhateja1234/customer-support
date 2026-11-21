package com.vcube.customer_support.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.customer_support.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    long countByRoleIgnoreCase(String role);
}