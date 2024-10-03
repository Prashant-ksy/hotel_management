package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Guest;
import com.HotelAndRest.springProject.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    // Constructor-based Dependency Injection
    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Add a new guest
    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }

    // Get all guests
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // Get guest by ID
    public Guest getGuestById(int guestId) {
        return guestRepository.findById(guestId);
    }

    // Update guest
    public void updateGuest(Guest guest) {
        guestRepository.update(guest);
    }

    // Delete guest by ID
    public void deleteGuest(int guestId) {
        guestRepository.delete(guestId);
    }
}
