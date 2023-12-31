package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Barista")

public  class Barista extends BaseEntity
{

    @Column(name = "Name", length = 32, nullable = false)
    private String name;
    @Column(name = "Rating", length = 6, nullable = false)
    private int rating;
    @Column(name = "Salary", length = 32, nullable = false)
    private BigDecimal salary;
    @Column(name = "PhoneNumber", length = 12, nullable = false)
    private long phone_number;
    //тут связи будут
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barista")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order> orders;



    public Barista(String name, int rating,BigDecimal salary, long phone_number) {
        this.name = name;
        this.rating = rating;
        this.salary = salary;
        this.phone_number = phone_number;
        this.orders = new HashSet<>();
    }

    protected Barista() {

    }

    //Геттеры
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public long getPhoneNumber() {
        return phone_number;
    }
    public Set<Order> getOrders() {
        return orders;
    }


    //Сеттеры
    private void setName(String name) {
        this.name = name;
    }
    private void setPhoneNumber(long phone_number) {
        this.phone_number = phone_number;
    }
    private void setRating(int rating) {
        this.rating = rating;
    }
    private void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }



}