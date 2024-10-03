package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Guest;
import com.HotelAndRest.springProject.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    // GET: /guests
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    // GET: /guests/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") int guestId) {
        Guest guest = guestService.getGuestById(guestId);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /guests
    @PostMapping
    public ResponseEntity<String> addGuest(@RequestBody Guest guest) {
        System.out.println(guest.getFirstName()+" "+guest.getLastName());
        guestService.addGuest(guest);
        return new ResponseEntity<>("Guest added successfully.", HttpStatus.CREATED);
    }

    // PUT: /guests/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable("id") int guestId, @RequestBody Guest guest) {
        guest.setGuestId(guestId);
        guestService.updateGuest(guest);
        return new ResponseEntity<>("Guest updated successfully.", HttpStatus.OK);
    }

    // DELETE: /guests/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") int guestId) {
        guestService.deleteGuest(guestId);
        return new ResponseEntity<>("Guest deleted successfully.", HttpStatus.OK);
    }
}
