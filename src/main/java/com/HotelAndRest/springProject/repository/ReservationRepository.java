package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a new reservation
    public void save(Reservation reservation) {
        String query = "INSERT INTO Reservation (Guest_ID, Hall_ID, Amount, FromDate, ToDate, Type) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                reservation.getGuestId(),
                reservation.getHallId(),
                reservation.getAmount(),
                reservation.getFromDate(),
                reservation.getToDate(),
                reservation.getType());
    }

    // Get all reservations
    public List<Reservation> findAll() {
        String query = "SELECT * FROM Reservation";
        return jdbcTemplate.query(query, (rs, rowNum) -> mapRow(rs));
    }

    // Find a reservation by guest ID and hall ID
    public Reservation findById(int guestId, int hallId) {
        String query = "SELECT * FROM Reservation WHERE Guest_ID = ? AND Hall_ID = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> mapRow(rs), guestId, hallId);
    }

    // Delete a reservation
    public void delete(int guestId, int hallId) {
        String query = "DELETE FROM Reservation WHERE Guest_ID = ? AND Hall_ID = ?";
        jdbcTemplate.update(query, guestId, hallId);
    }

    // Map ResultSet to Reservation object
    private Reservation mapRow(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setGuestId(rs.getInt("Guest_ID"));
        reservation.setHallId(rs.getInt("Hall_ID"));
        reservation.setAmount(rs.getBigDecimal("Amount"));
        reservation.setFromDate(rs.getDate("FromDate"));
        reservation.setToDate(rs.getDate("ToDate"));
        reservation.setType(rs.getString("Type"));
        return reservation;
    }
}
