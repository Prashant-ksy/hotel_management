package com.HotelAndRest.springProject.model;

import java.math.BigDecimal;
import java.util.Date;

public class Reservation {
    private int guestId;      // Foreign Key referencing Guest_ID
    private int hallId;       // Foreign Key referencing Hall_ID
    private BigDecimal amount; // Amount for the reservation
    private Date fromDate;    // Start date of the reservation
    private Date toDate;      // End date of the reservation
    private String type;      // Type of the reservation

    // Getters and Setters
    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
