
package com.vcube.customer_support.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.entity.Category;
import com.vcube.customer_support.repository.CategoryRepository;
import com.vcube.customer_support.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategory(Integer id, Category category) {

        Category existing = getCategoryById(id);

        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());

        return repository.save(existing);
    }

    @Override
    public void deleteCategory(Integer id) {

        Category existing = getCategoryById(id);

        repository.delete(existing);
    }
}
