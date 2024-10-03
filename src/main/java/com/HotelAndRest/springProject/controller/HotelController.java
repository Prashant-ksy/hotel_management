package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Hotel;
import com.HotelAndRest.springProject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // GET: /hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    // GET: /hotels/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") int hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /hotels
    @PostMapping
    public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return new ResponseEntity<>("Hotel added successfully.", HttpStatus.CREATED);
    }

    // PUT: /hotels/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateHotel(@PathVariable("id") int hotelId, @RequestBody Hotel hotel) {
        hotel.setHotelId(hotelId);
        hotelService.updateHotel(hotel);
        return new ResponseEntity<>("Hotel updated successfully.", HttpStatus.OK);
    }

    // DELETE: /hotels/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") int hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("Hotel deleted successfully.", HttpStatus.OK);
    }
}
