package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Booking;
import com.HotelAndRest.springProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // GET: /bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // GET: /bookings/{guestId}/{roomNo}
    @GetMapping("/{guestId}/{roomNo}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("guestId") int guestId, @PathVariable("roomNo") int roomNo) {
        Booking booking = bookingService.getBookingById(guestId, roomNo);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /bookings
    @PostMapping
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return new ResponseEntity<>("Booking added successfully.", HttpStatus.CREATED);
    }

    // PUT: /bookings/{guestId}/{roomNo}
    @PutMapping("/{guestId}/{roomNo}")
    public ResponseEntity<String> updateBooking(@PathVariable("guestId") int guestId, @PathVariable("roomNo") int roomNo, @RequestBody Booking booking) {
        booking.setGuestId(guestId);
        booking.setRoomNo(roomNo);
        bookingService.updateBooking(booking);
        return new ResponseEntity<>("Booking updated successfully.", HttpStatus.OK);
    }

    // DELETE: /bookings/{guestId}/{roomNo}
    @DeleteMapping("/{guestId}/{roomNo}")
    public ResponseEntity<String> deleteBooking(@PathVariable("guestId") int guestId, @PathVariable("roomNo") int roomNo) {
        bookingService.deleteBooking(guestId, roomNo);
        return new ResponseEntity<>("Booking deleted successfully.", HttpStatus.OK);
    }
}
