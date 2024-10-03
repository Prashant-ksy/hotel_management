package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Hotel;
import com.HotelAndRest.springProject.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // Add a new hotel
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by ID
    public Hotel getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId);
    }

    // Update hotel
    public void updateHotel(Hotel hotel) {
        hotelRepository.update(hotel);
    }

    // Delete hotel by ID
    public void deleteHotel(int hotelId) {
        hotelRepository.delete(hotelId);
    }
}
