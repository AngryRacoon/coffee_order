package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.*;

public class OrderCoffeeDTO {

    private Integer coffeeId;
    private Integer orderId;
    private int count;

    public OrderCoffeeDTO() {
        // Default constructor
    }

    public OrderCoffeeDTO(Integer coffeeId, Integer orderId, int count) {
        this.coffeeId = coffeeId;
        this.orderId = orderId;
        this.count = count;
    }

    // Getters and Setters

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

