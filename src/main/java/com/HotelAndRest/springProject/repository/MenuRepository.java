package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Menu objects
    private static final RowMapper<Menu> menuRowMapper = new RowMapper<Menu>() {
        @Override
        public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Menu menu = new Menu();
            menu.setDishId(rs.getInt("Dish_ID"));
            menu.setDName(rs.getString("D_Name"));
            menu.setPrice(rs.getDouble("Price"));
            menu.setDescription(rs.getString("Description"));
            menu.setHotelId(rs.getInt("Hotel_ID"));
            return menu;
        }
    };

    // Save a new menu item
    public void save(Menu menu) {
        String query = "INSERT INTO Menu (D_Name, Price, Description, Hotel_ID) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                menu.getDName(),
                menu.getPrice(),
                menu.getDescription(),
                menu.getHotelId());
    }

    // Get all menu items
    public List<Menu> findAll() {
        String query = "SELECT * FROM Menu";
        return jdbcTemplate.query(query, menuRowMapper);
    }

    // Find a menu item by dish ID
    public Menu findById(int dishId) {
        String query = "SELECT * FROM Menu WHERE Dish_ID = ?";
        return jdbcTemplate.queryForObject(query, menuRowMapper, dishId);
    }

    // Update a menu item
    public void update(Menu menu) {
        String query = "UPDATE Menu SET D_Name = ?, Price = ?, Description = ?, Hotel_ID = ? WHERE Dish_ID = ?";
        jdbcTemplate.update(query,
                menu.getDName(),
                menu.getPrice(),
                menu.getDescription(),
                menu.getHotelId(),
                menu.getDishId());
    }

    // Delete a menu item by dish ID
    public void delete(int dishId) {
        String query = "DELETE FROM Menu WHERE Dish_ID = ?";
        jdbcTemplate.update(query, dishId);
    }
}
