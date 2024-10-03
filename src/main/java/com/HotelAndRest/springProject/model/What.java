package com.HotelAndRest.springProject.model;

public class What {
    private int orderId;     // Foreign Key referencing Order_ID
    private int dishId;      // Foreign Key referencing Dish_ID
    private int quantity;     // Quantity of the dish in the order

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
