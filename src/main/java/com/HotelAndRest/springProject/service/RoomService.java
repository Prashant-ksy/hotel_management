package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Room;
import com.HotelAndRest.springProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Add a new room
    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Get room by room number
    public Room getRoomById(int roomNo) {
        return roomRepository.findById(roomNo);
    }

    // Update room
    public void updateRoom(Room room) {
        roomRepository.update(room);
    }

    // Delete room by room number
    public void deleteRoom(int roomNo) {
        roomRepository.delete(roomNo);
    }
}
