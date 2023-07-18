package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "Desk")
public  class Desk extends BaseEntity
{

    @Column(name = "Seats", nullable = false)
    private int seats;
    @Column(name = "Status", length = 32, nullable = false)
    private String status;
    //тут связи будут

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "desk")

    private Set<Order> orders;

    public Desk(int seats, String status) {
        this.seats = seats;
        this.status = status;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Desk() {

    }

    //Геттеры
    public int getSeats() {
        return seats;
    }

    public String getStatus() {
        return status;
    }



    //Сеттеры
    private void setSeats(int seats) {
        this.seats = seats;
    }

    private void setStatus(String status) {
        this.status = status;
    }



}