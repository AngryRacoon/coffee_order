package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;

public class OrderDto {

    private int order_id;
    private int customer_id;
    private int barista_id;
    private int desk_id;
    private java.sql.Timestamp timestamp;
    private boolean type;
    private String status;
    private Desk desk;
    private Barista barista;
    private Customer customer;
    //private Order order;

    public OrderDto(int order_id,int customer_id,
                    int desk_id,
                    int barista_id,
                    java.sql.Timestamp timestamp,
                    String status, boolean type)
    {
        this.order_id = order_id;
        this.desk_id = desk_id;
        this.customer_id = customer_id;
        this.barista_id = barista_id;
        this.timestamp = timestamp;
        this.status = status;
        this.type = type;
    }

    public OrderDto() {
    }

    //Геттеры
    public int getOrder_id() {
        return order_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public int getBarista_id() {
        return barista_id;
    }
    public int getDesk_id() {
        return desk_id;
    }


    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }
    public String getStatus() {
        return status;
    }
    public boolean getType() {
        return type;
    }

    /*public CoffeeDto getCoffee() {
        return coffee;
    }
*/

    //Сеттеры
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public void setBarista_id(int barista_id) {
        this.barista_id = barista_id;
    }
    public void setDesk_id(int desk_id) {
        this.desk_id = desk_id;
    }

    private void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private void setType(boolean type) {
        this.type = type;
    }



   /* public void setGroup(CoffeeDto group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

    */
}
