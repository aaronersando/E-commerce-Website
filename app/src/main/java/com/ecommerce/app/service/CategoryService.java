package com.ecommerce.app.service;

import java.util.List;
import com.ecommerce.app.model.Category;

import org.springframework.stereotype.Service;

import com.ecommerce.app.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
