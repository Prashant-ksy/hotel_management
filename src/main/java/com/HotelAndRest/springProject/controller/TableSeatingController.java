package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.TableSeating;
import com.HotelAndRest.springProject.service.TableSeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table-seating")
public class TableSeatingController {
    private final TableSeatingService tableSeatingService;

    @Autowired
    public TableSeatingController(TableSeatingService tableSeatingService) {
        this.tableSeatingService = tableSeatingService;
    }

    // GET: /table-seating
    @GetMapping
    public ResponseEntity<List<TableSeating>> getAllTableSeating() {
        List<TableSeating> tableSeatings = tableSeatingService.getAllTableSeating();
        return new ResponseEntity<>(tableSeatings, HttpStatus.OK);
    }

    // GET: /table-seating/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TableSeating> getTableSeatingById(@PathVariable("id") int tableId) {
        TableSeating tableSeating = tableSeatingService.getTableSeatingById(tableId);
        if (tableSeating != null) {
            return new ResponseEntity<>(tableSeating, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /table-seating
    @PostMapping
    public ResponseEntity<String> addTableSeating(@RequestBody TableSeating tableSeating) {
        tableSeatingService.addTableSeating(tableSeating);
        return new ResponseEntity<>("Table seating added successfully.", HttpStatus.CREATED);
    }

    // PUT: /table-seating/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTableSeating(@PathVariable("id") int tableId, @RequestBody TableSeating tableSeating) {
        tableSeating.setTableId(tableId);
        tableSeatingService.updateTableSeating(tableSeating);
        return new ResponseEntity<>("Table seating updated successfully.", HttpStatus.OK);
    }

    // DELETE: /table-seating/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTableSeating(@PathVariable("id") int tableId) {
        tableSeatingService.deleteTableSeating(tableId);
        return new ResponseEntity<>("Table seating deleted successfully.", HttpStatus.OK);
    }
}
