package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class OrderCoffeeDTO {

    @JsonIgnore
    private Coffee coffee;
    
    private Order order;
    private int count;

    public OrderCoffeeDTO() {
        // Default constructor
    }

    public OrderCoffeeDTO(Coffee coffee, Order order, int count) {
        this.coffee = coffee;
        this.order = order;
        this.count = count;
    }

    // Getters and Setters

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffeeId(Coffee coffee) {
        this.coffee = coffee;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

