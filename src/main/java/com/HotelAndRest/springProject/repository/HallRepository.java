package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HallRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HallRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Hall objects
    private static final RowMapper<Hall> hallRowMapper = new RowMapper<Hall>() {
        @Override
        public Hall mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hall hall = new Hall();
            hall.setHallId(rs.getInt("Hall_ID"));
            hall.setCapacity(rs.getInt("Capacity"));
            hall.setCommUnit(rs.getString("CommUnit"));
            hall.setHotelId(rs.getInt("Hotel_ID"));
            return hall;
        }
    };

    // Save a new hall
    public void save(Hall hall) {
        String query = "INSERT INTO Hall (Capacity, CommUnit, Hotel_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(query,
                hall.getCapacity(),
                hall.getCommUnit(),
                hall.getHotelId());
    }

    // Get all halls
    public List<Hall> findAll() {
        String query = "SELECT * FROM Hall";
        return jdbcTemplate.query(query, hallRowMapper);
    }

    // Find a hall by hall ID
    public Hall findById(int hallId) {
        String query = "SELECT * FROM Hall WHERE Hall_ID = ?";
        return jdbcTemplate.queryForObject(query, hallRowMapper, hallId);
    }

    // Update a hall
    public void update(Hall hall) {
        String query = "UPDATE Hall SET Capacity = ?, CommUnit = ?, Hotel_ID = ? WHERE Hall_ID = ?";
        jdbcTemplate.update(query,
                hall.getCapacity(),
                hall.getCommUnit(),
                hall.getHotelId(),
                hall.getHallId());
    }

    // Delete a hall by hall ID
    public void delete(int hallId) {
        String query = "DELETE FROM Hall WHERE Hall_ID = ?";
        jdbcTemplate.update(query, hallId);
    }
}
