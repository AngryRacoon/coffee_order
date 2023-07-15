package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

@Entity
class OrderCoffee {

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

    private void setId(CoffeeOrderKey id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    private void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Order getOrder() {
        return order;
    }

    private void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }
}
