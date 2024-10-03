package com.HotelAndRest.springProject.model;

public class Hall {
    private int hallId;       // Primary Key
    private int capacity;
    private String commUnit;
    private int hotelId;      // Foreign Key referencing Hotel_ID

    // Getters and Setters
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
