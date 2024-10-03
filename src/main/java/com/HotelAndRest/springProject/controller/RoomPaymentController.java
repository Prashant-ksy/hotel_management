package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.RoomPayment;
import com.HotelAndRest.springProject.service.RoomPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-payments")
public class RoomPaymentController {
    private final RoomPaymentService roomPaymentService;

    @Autowired
    public RoomPaymentController(RoomPaymentService roomPaymentService) {
        this.roomPaymentService = roomPaymentService;
    }

    // GET: /room-payments
    @GetMapping
    public ResponseEntity<List<RoomPayment>> getAllRoomPayments() {
        List<RoomPayment> roomPayments = roomPaymentService.getAllRoomPayments();
        return new ResponseEntity<>(roomPayments, HttpStatus.OK);
    }

    // POST: /room-payments
    @PostMapping
    public ResponseEntity<String> addRoomPayment(@RequestBody RoomPayment roomPayment) {
        roomPaymentService.addRoomPayment(roomPayment);
        return new ResponseEntity<>("Room payment added successfully.", HttpStatus.CREATED);
    }

    // DELETE: /room-payments
    @DeleteMapping
    public ResponseEntity<String> deleteRoomPayment(@RequestParam int roomNo, @RequestParam int payId) {
        roomPaymentService.deleteRoomPayment(roomNo, payId);
        return new ResponseEntity<>("Room payment deleted successfully.", HttpStatus.OK);
    }
}
