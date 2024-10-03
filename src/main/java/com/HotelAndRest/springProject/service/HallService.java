package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Hall;
import com.HotelAndRest.springProject.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    // Add a new hall
    public void addHall(Hall hall) {
        hallRepository.save(hall);
    }

    // Get all halls
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    // Get hall by hall ID
    public Hall getHallById(int hallId) {
        return hallRepository.findById(hallId);
    }

    // Update hall
    public void updateHall(Hall hall) {
        hallRepository.update(hall);
    }

    // Delete hall by hall ID
    public void deleteHall(int hallId) {
        hallRepository.delete(hallId);
    }
}
