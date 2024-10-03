package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Payment objects
    private static final RowMapper<Payment> paymentRowMapper = new RowMapper<Payment>() {
        @Override
        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payment payment = new Payment();
            payment.setPayId(rs.getInt("Pay_ID"));
            payment.setMethod(rs.getString("Method"));
            payment.setStatus(rs.getString("Status"));
            payment.setDateTime(rs.getTimestamp("DateTime").toLocalDateTime());
            payment.setOrderId(rs.getInt("Order_ID"));
            return payment;
        }
    };

    // Save a new payment
    public void save(Payment payment) {
        String query = "INSERT INTO Payment (Method, Status, DateTime, Order_ID) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                payment.getMethod(),
                payment.getStatus(),
                payment.getDateTime(),
                payment.getOrderId());
    }

    // Get all payments
    public List<Payment> findAll() {
        String query = "SELECT * FROM Payment";
        return jdbcTemplate.query(query, paymentRowMapper);
    }

    // Find a payment by Pay ID
    public Payment findById(int payId) {
        String query = "SELECT * FROM Payment WHERE Pay_ID = ?";
        return jdbcTemplate.queryForObject(query, paymentRowMapper, payId);
    }

    // Update a payment
    public void update(Payment payment) {
        String query = "UPDATE Payment SET Method = ?, Status = ?, DateTime = ?, Order_ID = ? WHERE Pay_ID = ?";
        jdbcTemplate.update(query,
                payment.getMethod(),
                payment.getStatus(),
                payment.getDateTime(),
                payment.getOrderId(),
                payment.getPayId());
    }

    // Delete a payment by Pay ID
    public void delete(int payId) {
        String query = "DELETE FROM Payment WHERE Pay_ID = ?";
        jdbcTemplate.update(query, payId);
    }
}
