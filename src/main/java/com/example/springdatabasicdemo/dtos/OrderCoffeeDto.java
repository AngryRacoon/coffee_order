package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.*;

public class OrderCoffeeDto {

    private int coffee_order_key_id;
    private int coffee_id;
    private int order_id;
    Coffee coffee;
    Order order;
    int count;

    //private Order order;

    public OrderCoffeeDto(int order_id,int coffee_order_key_id,
                    int coffee_id,
                          int count, Order order,Coffee coffee)
    {
        this.order_id = order_id;
        this.coffee_order_key_id = coffee_order_key_id;
        this.coffee_id = coffee_id;
        this.order = order;this.coffee = coffee;
        this.coffee = coffee;
        this.order = order;
        this.count = count;

    }

    public OrderCoffeeDto() {
    }

    //Геттеры
    public int getOrder_id() {
        return order_id;
    }
    public int getCoffeeOrderKeyId() {
        return coffee_order_key_id;
    }
    public int getCoffeeId() {
        return coffee_id;
    }


    private void setOrder_id(Order order) {
        this.order = order;
    }

    private void setCoffeeId(int coffee_id) {
        this.coffee_id = coffee_id;
    }
    private void setCoffeeOrderKeyId(int coffee_order_key_id) {
        this.coffee_order_key_id = coffee_order_key_id;
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


   /* public void setGroup(OrderCoffeeDto group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

    */
}
