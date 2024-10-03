package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.What;
import com.HotelAndRest.springProject.service.WhatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whats")
public class WhatController {
    private final WhatService whatService;

    @Autowired
    public WhatController(WhatService whatService) {
        this.whatService = whatService;
    }

    // GET: /whats
    @GetMapping
    public ResponseEntity<List<What>> getAllWhats() {
        List<What> whats = whatService.getAllWhats();
        return new ResponseEntity<>(whats, HttpStatus.OK);
    }

    // POST: /whats
    @PostMapping
    public ResponseEntity<String> addWhat(@RequestBody What what) {
        whatService.addWhat(what);
        return new ResponseEntity<>("What entry added successfully.", HttpStatus.CREATED);
    }

    // DELETE: /whats
    @DeleteMapping
    public ResponseEntity<String> deleteWhat(@RequestParam int orderId, @RequestParam int dishId) {
        whatService.deleteWhat(orderId, dishId);
        return new ResponseEntity<>("What entry deleted successfully.", HttpStatus.OK);
    }
}
