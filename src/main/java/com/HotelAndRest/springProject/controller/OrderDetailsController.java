package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.OrderDetails;
import com.HotelAndRest.springProject.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    // GET: /order-details
    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    // GET: /order-details/{id}
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable("id") int orderId) {
        OrderDetails orderDetails = orderDetailsService.getOrderDetailsById(orderId);
        if (orderDetails != null) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /order-details
    @PostMapping
    public ResponseEntity<String> addOrderDetails(@RequestBody OrderDetails orderDetails) {
        orderDetailsService.addOrderDetails(orderDetails);
        return new ResponseEntity<>("Order detail added successfully.", HttpStatus.CREATED);
    }

    // PUT: /order-details/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrderDetails(@PathVariable("id") int orderId, @RequestBody OrderDetails orderDetails) {
        orderDetails.setOrderId(orderId);
        orderDetailsService.updateOrderDetails(orderDetails);
        return new ResponseEntity<>("Order detail updated successfully.", HttpStatus.OK);
    }

    // DELETE: /order-details/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDetails(@PathVariable("id") int orderId) {
        orderDetailsService.deleteOrderDetails(orderId);
        return new ResponseEntity<>("Order detail deleted successfully.", HttpStatus.OK);
    }
}
