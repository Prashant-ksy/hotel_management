package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDetailsRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDetailsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to OrderDetails objects
    private static final RowMapper<OrderDetails> orderDetailsRowMapper = new RowMapper<OrderDetails>() {
        @Override
        public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(rs.getInt("Order_ID"));
            orderDetails.setDateTime(rs.getTimestamp("DateTime").toLocalDateTime());
            orderDetails.setAmount(rs.getDouble("Amount"));
            orderDetails.setGuestId(rs.getInt("Guest_ID"));
            orderDetails.setTableId(rs.getInt("Table_ID"));
            return orderDetails;
        }
    };

    // Save a new order detail
    public void save(OrderDetails orderDetails) {
        String query = "INSERT INTO Order_Details (DateTime, Amount, Guest_ID, Table_ID) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                orderDetails.getDateTime(),
                orderDetails.getAmount(),
                orderDetails.getGuestId(),
                orderDetails.getTableId());
    }

    // Get all order details
    public List<OrderDetails> findAll() {
        String query = "SELECT * FROM Order_Details";
        return jdbcTemplate.query(query, orderDetailsRowMapper);
    }

    // Find an order detail by order ID
    public OrderDetails findById(int orderId) {
        String query = "SELECT * FROM Order_Details WHERE Order_ID = ?";
        return jdbcTemplate.queryForObject(query, orderDetailsRowMapper, orderId);
    }

    // Update an order detail
    public void update(OrderDetails orderDetails) {
        String query = "UPDATE Order_Details SET DateTime = ?, Amount = ?, Guest_ID = ?, Table_ID = ? WHERE Order_ID = ?";
        jdbcTemplate.update(query,
                orderDetails.getDateTime(),
                orderDetails.getAmount(),
                orderDetails.getGuestId(),
                orderDetails.getTableId(),
                orderDetails.getOrderId());
    }

    // Delete an order detail by order ID
    public void delete(int orderId) {
        String query = "DELETE FROM Order_Details WHERE Order_ID = ?";
        jdbcTemplate.update(query, orderId);
    }
}
