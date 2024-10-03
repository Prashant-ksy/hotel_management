package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.TableSeating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TableSeatingRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TableSeatingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to TableSeating objects
    private static final RowMapper<TableSeating> tableSeatingRowMapper = new RowMapper<TableSeating>() {
        @Override
        public TableSeating mapRow(ResultSet rs, int rowNum) throws SQLException {
            TableSeating tableSeating = new TableSeating();
            tableSeating.setTableId(rs.getInt("Table_ID"));
            tableSeating.setCapacity(rs.getInt("Capacity"));
            tableSeating.setAvailability(rs.getString("Availability"));
            return tableSeating;
        }
    };

    // Save a new table seating
    public void save(TableSeating tableSeating) {
        String query = "INSERT INTO Table_Seating (Capacity, Availability) VALUES (?, ?)";
        jdbcTemplate.update(query,
                tableSeating.getCapacity(),
                tableSeating.getAvailability());
    }

    // Get all table seating
    public List<TableSeating> findAll() {
        String query = "SELECT * FROM Table_Seating";
        return jdbcTemplate.query(query, tableSeatingRowMapper);
    }

    // Find a table seating by table ID
    public TableSeating findById(int tableId) {
        String query = "SELECT * FROM Table_Seating WHERE Table_ID = ?";
        return jdbcTemplate.queryForObject(query, tableSeatingRowMapper, tableId);
    }

    // Update a table seating
    public void update(TableSeating tableSeating) {
        String query = "UPDATE Table_Seating SET Capacity = ?, Availability = ? WHERE Table_ID = ?";
        jdbcTemplate.update(query,
                tableSeating.getCapacity(),
                tableSeating.getAvailability(),
                tableSeating.getTableId());
    }

    // Delete a table seating by table ID
    public void delete(int tableId) {
        String query = "DELETE FROM Table_Seating WHERE Table_ID = ?";
        jdbcTemplate.update(query, tableId);
    }
}
