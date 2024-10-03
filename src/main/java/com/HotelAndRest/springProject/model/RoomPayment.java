package com.HotelAndRest.springProject.model;

public class RoomPayment {
    private int roomNo;    // Foreign Key referencing Room_No
    private int payId;     // Foreign Key referencing Pay_ID

    // Getters and Setters
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }
}
