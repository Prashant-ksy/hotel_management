package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Reservation;
import com.HotelAndRest.springProject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Add a new reservation
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get reservation by guest ID and hall ID
    public Reservation getReservationById(int guestId, int hallId) {
        return reservationRepository.findById(guestId, hallId);
    }

    // Delete reservation
    public void deleteReservation(int guestId, int hallId) {
        reservationRepository.delete(guestId, hallId);
    }
}
