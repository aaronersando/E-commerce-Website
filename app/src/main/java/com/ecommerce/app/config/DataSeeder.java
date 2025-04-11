package com.ecommerce.app.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.app.model.Category;
import com.ecommerce.app.model.Product;
import com.ecommerce.app.repository.CategoryRepository;
import com.ecommerce.app.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Seed categories
        categoryRepository.saveAll(List.of(
            new Category(1, "Electronics"),
            new Category(2, "Books"),
            new Category(3, "Clothing")
        ));

        // Seed products with category IDs
        productRepository.saveAll(List.of(
            new Product(null, "Laptop", "High performance laptop", 1200.00, "https://placehold.co/600x400", 1), // Electronics
            new Product(null, "Smartphone", "Latest model smartphone", 800.00, "https://placehold.co/600x400", 1), // Electronics
            new Product(null, "Novel", "Bestselling novel", 20.00, "https://placehold.co/600x400", 2), // Books
            new Product(null, "T-shirt", "Comfortable cotton t-shirt", 15.00, "https://placehold.co/600x400", 3) // Clothing
        ));
    }
}