package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.RoomPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomPaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomPaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a new RoomPayment entry
    public void save(RoomPayment roomPayment) {
        String query = "INSERT INTO Room_Payment (Room_No, Pay_ID) VALUES (?, ?)";
        jdbcTemplate.update(query, roomPayment.getRoomNo(), roomPayment.getPayId());
    }

    // Get all RoomPayment entries
    public List<RoomPayment> findAll() {
        String query = "SELECT * FROM Room_Payment";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            RoomPayment roomPayment = new RoomPayment();
            roomPayment.setRoomNo(rs.getInt("Room_No"));
            roomPayment.setPayId(rs.getInt("Pay_ID"));
            return roomPayment;
        });
    }

    // Delete a RoomPayment entry by room number and payment ID
    public void delete(int roomNo, int payId) {
        String query = "DELETE FROM Room_Payment WHERE Room_No = ? AND Pay_ID = ?";
        jdbcTemplate.update(query, roomNo, payId);
    }
}
