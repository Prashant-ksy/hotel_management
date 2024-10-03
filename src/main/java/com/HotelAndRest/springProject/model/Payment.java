package com.HotelAndRest.springProject.model;

import java.time.LocalDateTime;

public class Payment {
    private int payId;            // Primary Key
    private String method;
    private String status;
    private LocalDateTime dateTime;
    private int orderId;          // Foreign Key referencing Order_ID

    // Getters and Setters
    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
