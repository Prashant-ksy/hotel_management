package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Reservation;
import com.HotelAndRest.springProject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // GET: /reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    // GET: /reservations/{guestId}/{hallId}
    @GetMapping("/{guestId}/{hallId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int guestId, @PathVariable int hallId) {
        Reservation reservation = reservationService.getReservationById(guestId, hallId);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /reservations
    @PostMapping
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
        return new ResponseEntity<>("Reservation added successfully.", HttpStatus.CREATED);
    }

    // DELETE: /reservations/{guestId}/{hallId}
    @DeleteMapping("/{guestId}/{hallId}")
    public ResponseEntity<String> deleteReservation(@PathVariable int guestId, @PathVariable int hallId) {
        reservationService.deleteReservation(guestId, hallId);
        return new ResponseEntity<>("Reservation deleted successfully.", HttpStatus.OK);
    }
}
