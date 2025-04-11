package com.ecommerce.app.repository;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

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

    public void saveAll(List<Product> products) {
        for (Product product : products) {
            int updated = jdbcClient.sql("INSERT INTO Product (name, description, price, image_url, category_id) VALUES (?, ?, ?, ?, ?)")
                    .params(product.name(), product.description(), product.price(), product.image_url(), product.category_id()) // Bind product fields
                    .update();
    
            Assert.state(updated == 1, "Failed to insert product: " + product.name());
        }
    }

    public void deleteAll() {
        int deleted = jdbcClient.sql("DELETE FROM product")
                .update();
    
        Assert.state(deleted >= 0, "Failed to delete products. Deleted rows: " + deleted);
    }

}
