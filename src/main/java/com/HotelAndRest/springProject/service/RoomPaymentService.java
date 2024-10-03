package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.RoomPayment;
import com.HotelAndRest.springProject.repository.RoomPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomPaymentService {
    private final RoomPaymentRepository roomPaymentRepository;

    @Autowired
    public RoomPaymentService(RoomPaymentRepository roomPaymentRepository) {
        this.roomPaymentRepository = roomPaymentRepository;
    }

    // Add a new RoomPayment
    public void addRoomPayment(RoomPayment roomPayment) {
        roomPaymentRepository.save(roomPayment);
    }

    // Get all RoomPayments
    public List<RoomPayment> getAllRoomPayments() {
        return roomPaymentRepository.findAll();
    }

    // Delete RoomPayment by room number and payment ID
    public void deleteRoomPayment(int roomNo, int payId) {
        roomPaymentRepository.delete(roomNo, payId);
    }
}
