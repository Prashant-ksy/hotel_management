package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HotelRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HotelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Hotel objects
    private static final RowMapper<Hotel> hotelRowMapper = new RowMapper<Hotel>() {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hotel hotel = new Hotel();
            hotel.setHotelId(rs.getInt("Hotel_ID"));
            hotel.setHName(rs.getString("H_Name"));
            hotel.setLocation(rs.getString("Location"));
            hotel.setEmail(rs.getString("E_mail"));
            hotel.setContactNo(rs.getString("Contact_No"));
            return hotel;
        }
    };

    // Save a new hotel
    public void save(Hotel hotel) {
        String query = "INSERT INTO Hotel (H_Name, Location, E_mail, Contact_No) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                hotel.getHName(),
                hotel.getLocation(),
                hotel.getEmail(),
                hotel.getContactNo());
    }

    // Get all hotels
    public List<Hotel> findAll() {
        String query = "SELECT * FROM Hotel";
        return jdbcTemplate.query(query, hotelRowMapper);
    }

    // Find a hotel by ID
    public Hotel findById(int hotelId) {
        String query = "SELECT * FROM Hotel WHERE Hotel_ID = ?";
        return jdbcTemplate.queryForObject(query, hotelRowMapper, hotelId);
    }

    // Update a hotel
    public void update(Hotel hotel) {
        String query = "UPDATE Hotel SET H_Name = ?, Location = ?, E_mail = ?, Contact_No = ? WHERE Hotel_ID = ?";
        jdbcTemplate.update(query,
                hotel.getHName(),
                hotel.getLocation(),
                hotel.getEmail(),
                hotel.getContactNo(),
                hotel.getHotelId());
    }

    // Delete a hotel by ID
    public void delete(int hotelId) {
        String query = "DELETE FROM Hotel WHERE Hotel_ID = ?";
        jdbcTemplate.update(query, hotelId);
    }
}
