package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.What;
import com.HotelAndRest.springProject.repository.WhatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhatService {
    private final WhatRepository whatRepository;

    @Autowired
    public WhatService(WhatRepository whatRepository) {
        this.whatRepository = whatRepository;
    }

    // Add a new What entry
    public void addWhat(What what) {
        whatRepository.save(what);
    }

    // Get all What entries
    public List<What> getAllWhats() {
        return whatRepository.findAll();
    }

    // Delete What entry by order ID and dish ID
    public void deleteWhat(int orderId, int dishId) {
        whatRepository.delete(orderId, dishId);
    }
}
