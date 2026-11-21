
package com.vcube.customer_support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.customer_support.entity.Category;
import com.vcube.customer_support.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable Integer id,
            @RequestBody Category category) {

        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return "Category deleted successfully";
    }
}

//POST   http://localhost:8080/api/categories
//
//GET    http://localhost:8080/api/categories
//
//GET    http://localhost:8080/api/categories/1
//
//PUT    http://localhost:8080/api/categories/1
//
//DELETE http://localhost:8080/api/categories/1
