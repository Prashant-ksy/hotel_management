package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GuestRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Guest objects
    private static final RowMapper<Guest> guestRowMapper = new RowMapper<Guest>() {
        @Override
        public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
            Guest guest = new Guest();
            guest.setGuestId(rs.getInt("Guest_ID"));
            guest.setFirstName(rs.getString("F_Name"));
            guest.setLastName(rs.getString("L_Name"));
            guest.setDob(rs.getString("DOB"));
            guest.setPhoneNo(rs.getString("Phone_No"));
            guest.setAddress(rs.getString("Address"));
            guest.setHotelId(rs.getInt("Hotel_ID"));
            return guest;
        }
    };

    // Save a new guest
    public void save(Guest guest) {
        String query = "INSERT INTO Guest (F_Name, L_Name, DOB, Phone_No, Address, Hotel_ID) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                guest.getFirstName(),
                guest.getLastName(),
                guest.getDob(),
                guest.getPhoneNo(),
                guest.getAddress(),
                guest.getHotelId());
    }

    // Get all guests
    public List<Guest> findAll() {
        String query = "SELECT * FROM Guest";
        return jdbcTemplate.query(query, guestRowMapper);
    }

    // Find a guest by ID
    public Guest findById(int guestId) {
        String query = "SELECT * FROM Guest WHERE Guest_ID = ?";
        return jdbcTemplate.queryForObject(query, guestRowMapper, guestId);
    }

    // Update a guest
    public void update(Guest guest) {
        String query = "UPDATE Guest SET F_Name = ?, L_Name = ?, DOB = ?, Phone_No = ?, Address = ?, Hotel_ID = ? WHERE Guest_ID = ?";
        jdbcTemplate.update(query,
                guest.getFirstName(),
                guest.getLastName(),
                guest.getDob(),
                guest.getPhoneNo(),
                guest.getAddress(),
                guest.getHotelId(),
                guest.getGuestId());
    }

    // Delete a guest by ID
    public void delete(int guestId) {
        String query = "DELETE FROM Guest WHERE Guest_ID = ?";
        jdbcTemplate.update(query, guestId);
    }
}
