package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.TableSeating;
import com.HotelAndRest.springProject.repository.TableSeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableSeatingService {
    private final TableSeatingRepository tableSeatingRepository;

    @Autowired
    public TableSeatingService(TableSeatingRepository tableSeatingRepository) {
        this.tableSeatingRepository = tableSeatingRepository;
    }

    // Add a new table seating
    public void addTableSeating(TableSeating tableSeating) {
        tableSeatingRepository.save(tableSeating);
    }

    // Get all table seating
    public List<TableSeating> getAllTableSeating() {
        return tableSeatingRepository.findAll();
    }

    // Get table seating by table ID
    public TableSeating getTableSeatingById(int tableId) {
        return tableSeatingRepository.findById(tableId);
    }

    // Update table seating
    public void updateTableSeating(TableSeating tableSeating) {
        tableSeatingRepository.update(tableSeating);
    }

    // Delete table seating by table ID
    public void deleteTableSeating(int tableId) {
        tableSeatingRepository.delete(tableId);
    }
}
