package com.vcube.customer_support.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.customer_support.entity.Category;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {
}