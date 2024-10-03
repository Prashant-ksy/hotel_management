package com.HotelAndRest.springProject.model;

import java.time.LocalDate;

public class Booking {
    private int guestId;          // Foreign Key referencing Guest_ID
    private int roomNo;           // Foreign Key referencing Room_No
    private double amount;
    private LocalDate checkIn;    // Check-in date
    private LocalDate checkOut;   // Check-out date

    // Getters and Setters
    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
