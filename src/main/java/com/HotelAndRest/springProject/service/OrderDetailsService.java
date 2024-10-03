package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.OrderDetails;
import com.HotelAndRest.springProject.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    // Add a new order detail
    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }

    // Get all order details
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    // Get order detail by order ID
    public OrderDetails getOrderDetailsById(int orderId) {
        return orderDetailsRepository.findById(orderId);
    }

    // Update order detail
    public void updateOrderDetails(OrderDetails orderDetails) {
        orderDetailsRepository.update(orderDetails);
    }

    // Delete order detail by order ID
    public void deleteOrderDetails(int orderId) {
        orderDetailsRepository.delete(orderId);
    }
}
