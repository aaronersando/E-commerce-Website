package com.ecommerce.app.repository;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.model.Product;

@Repository
public class ProductRepository {

    private final JdbcClient jdbcClient;

    public ProductRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Product> findAll() {
        return jdbcClient.sql("select * from product")
                .query(Product.class)
                .list();
    }

    public List<Product> findByCategoryId(Integer categoryId) {
        return jdbcClient.sql("select * from product where category_id = ?")
                .param(categoryId) // Bind the categoryId parameter
                .query(Product.class)
                .list();
    }

}
