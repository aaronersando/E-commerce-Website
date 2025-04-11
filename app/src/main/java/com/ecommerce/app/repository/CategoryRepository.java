package com.ecommerce.app.repository;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.ecommerce.app.model.Category;

@Repository
public class CategoryRepository {

    private final JdbcClient jdbcClient;

    public CategoryRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Category> findAll() {
        return jdbcClient.sql("select * from category")
                .query(Category.class)
                .list();
    }

    public void saveAll(List<Category> categories) {
        for (Category category : categories) {
            int updated = jdbcClient.sql("INSERT INTO Category (id, name) VALUES (?, ?)")
                    .params(category.id(), category.name()) // Bind id and name
                    .update();
    
            Assert.state(updated == 1, "Failed to insert category: " + category.name());
        }
    }

    public void deleteAll() {
        int deleted = jdbcClient.sql("DELETE FROM category")
                .update();
    
        Assert.state(deleted >= 0, "Failed to delete categories. Deleted rows: " + deleted);
    }
}


