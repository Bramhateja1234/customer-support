
package com.vcube.customer_support.service;

import java.util.List;
import com.vcube.customer_support.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Integer id);

    Category updateCategory(Integer id, Category category);

    void deleteCategory(Integer id);
}
