package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.sql.Timestamp;
import java.util.Set;

public class OrderDto {

    private Integer order_id;
    private CustomerDto customer;
    private BaristaDto barista;
    private DeskDto desk;

    private Set<OrderCoffeeDTO> coffees;
    private Timestamp timestamp;
    private boolean type;
    private String status;

    public OrderDto() {
        // Пустой конструктор
    }

    public OrderDto(Integer order_id, CustomerDto customer, DeskDto desk, BaristaDto barista, Timestamp timestamp, String status, boolean type) {
        this.order_id = order_id;
        this.customer = customer;
        this.desk = desk;
        this.barista = barista;
        this.timestamp = timestamp;
        this.status = status;
        this.type = type;
    }

    // Getters and Setters

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public BaristaDto getBarista() {
        return barista;
    }

    public void setBarista(BaristaDto barista) {
        this.barista = barista;
    }

    public DeskDto getDesk() {
        return desk;
    }

    public void setDesk(DeskDto desk) {
        this.desk = desk;
    }

    public Set<OrderCoffeeDTO> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<OrderCoffeeDTO> coffees) {
        this.coffees = coffees;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
