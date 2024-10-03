package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Room;
import com.HotelAndRest.springProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // GET: /rooms
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    // GET: /rooms/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") int roomNo) {
        Room room = roomService.getRoomById(roomNo);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /rooms
    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return new ResponseEntity<>("Room added successfully.", HttpStatus.CREATED);
    }

    // PUT: /rooms/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRoom(@PathVariable("id") int roomNo, @RequestBody Room room) {
        room.setRoomNo(roomNo);
        roomService.updateRoom(room);
        return new ResponseEntity<>("Room updated successfully.", HttpStatus.OK);
    }

    // DELETE: /rooms/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") int roomNo) {
        roomService.deleteRoom(roomNo);
        return new ResponseEntity<>("Room deleted successfully.", HttpStatus.OK);
    }
}
