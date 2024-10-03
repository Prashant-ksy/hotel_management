package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Booking objects
    private static final RowMapper<Booking> bookingRowMapper = new RowMapper<Booking>() {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            Booking booking = new Booking();
            booking.setGuestId(rs.getInt("Guest_ID"));
            booking.setRoomNo(rs.getInt("Room_No"));
            booking.setAmount(rs.getBigDecimal("Amount").doubleValue());
            booking.setCheckIn(rs.getDate("C_in").toLocalDate());
            booking.setCheckOut(rs.getDate("C_out").toLocalDate());
            return booking;
        }
    };

    // Save a new booking
    public void save(Booking booking) {
        String query = "INSERT INTO Booking (Guest_ID, Room_No, Amount, C_in, C_out) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                booking.getGuestId(),
                booking.getRoomNo(),
                booking.getAmount(),
                booking.getCheckIn(),
                booking.getCheckOut());
    }

    // Get all bookings
    public List<Booking> findAll() {
        String query = "SELECT * FROM Booking";
        return jdbcTemplate.query(query, bookingRowMapper);
    }

    // Find a booking by Guest ID and Room No
    public Booking findById(int guestId, int roomNo) {
        String query = "SELECT * FROM Booking WHERE Guest_ID = ? AND Room_No = ?";
        return jdbcTemplate.queryForObject(query, bookingRowMapper, guestId, roomNo);
    }

    // Update a booking
    public void update(Booking booking) {
        String query = "UPDATE Booking SET Amount = ?, C_in = ?, C_out = ? WHERE Guest_ID = ? AND Room_No = ?";
        jdbcTemplate.update(query,
                booking.getAmount(),
                booking.getCheckIn(),
                booking.getCheckOut(),
                booking.getGuestId(),
                booking.getRoomNo());
    }

    // Delete a booking by Guest ID and Room No
    public void delete(int guestId, int roomNo) {
        String query = "DELETE FROM Booking WHERE Guest_ID = ? AND Room_No = ?";
        jdbcTemplate.update(query, guestId, roomNo);
    }
}
