package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.What;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WhatRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WhatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a new entry in What table
    public void save(What what) {
        String query = "INSERT INTO What (Order_ID, Dish_ID, Quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, what.getOrderId(), what.getDishId(), what.getQuantity());
    }

    // Get all entries from What table
    public List<What> findAll() {
        String query = "SELECT * FROM What";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            What what = new What();
            what.setOrderId(rs.getInt("Order_ID"));
            what.setDishId(rs.getInt("Dish_ID"));
            what.setQuantity(rs.getInt("Quantity"));
            return what;
        });
    }

    // Delete an entry from What table by order ID and dish ID
    public void delete(int orderId, int dishId) {
        String query = "DELETE FROM What WHERE Order_ID = ? AND Dish_ID = ?";
        jdbcTemplate.update(query, orderId, dishId);
    }
}
