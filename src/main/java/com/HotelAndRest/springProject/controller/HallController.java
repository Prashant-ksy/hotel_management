package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Hall;
import com.HotelAndRest.springProject.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {
    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    // GET: /halls
    @GetMapping
    public ResponseEntity<List<Hall>> getAllHalls() {
        List<Hall> halls = hallService.getAllHalls();
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }

    // GET: /halls/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable("id") int hallId) {
        Hall hall = hallService.getHallById(hallId);
        if (hall != null) {
            return new ResponseEntity<>(hall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /halls
    @PostMapping
    public ResponseEntity<String> addHall(@RequestBody Hall hall) {
        hallService.addHall(hall);
        return new ResponseEntity<>("Hall added successfully.", HttpStatus.CREATED);
    }

    // PUT: /halls/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateHall(@PathVariable("id") int hallId, @RequestBody Hall hall) {
        hall.setHallId(hallId);
        hallService.updateHall(hall);
        return new ResponseEntity<>("Hall updated successfully.", HttpStatus.OK);
    }

    // DELETE: /halls/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHall(@PathVariable("id") int hallId) {
        hallService.deleteHall(hallId);
        return new ResponseEntity<>("Hall deleted successfully.", HttpStatus.OK);
    }
}
