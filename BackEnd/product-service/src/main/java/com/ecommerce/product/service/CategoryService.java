package com.ecommerce.product.service;

import com.ecommerce.product.model.Category;
import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryByName(String name);
}