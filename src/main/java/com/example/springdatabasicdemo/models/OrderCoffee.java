package com.example.springdatabasicdemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
public class OrderCoffee {

    @EmbeddedId
    CoffeeOrderKey id;

    @ManyToOne
    @MapsId("coffeeId")
    @JoinColumn(name = "coffee_id")
    Coffee coffee;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    int count;

    public OrderCoffee() {
        // Default constructor
    }

    public OrderCoffee(CoffeeOrderKey id, Coffee coffee, Order order, int count) {
        this.id = id;
        this.coffee = coffee;
        this.order = order;
        this.count = count;
    }

    // Getters and Setters

    public CoffeeOrderKey getId() {
        return id;
    }

    public void setId(CoffeeOrderKey id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
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
