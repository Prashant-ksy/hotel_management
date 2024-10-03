package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Booking;
import com.HotelAndRest.springProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by Guest ID and Room No
    public Booking getBookingById(int guestId, int roomNo) {
        return bookingRepository.findById(guestId, roomNo);
    }

    // Update booking
    public void updateBooking(Booking booking) {
        bookingRepository.update(booking);
    }

    // Delete booking by Guest ID and Room No
    public void deleteBooking(int guestId, int roomNo) {
        bookingRepository.delete(guestId, roomNo);
    }
}
