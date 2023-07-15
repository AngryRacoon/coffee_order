package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Table")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Table extends BaseEntity
{

    @Column(name = "Seats", nullable = false)
    private int seats;
    @Column(name = "Status", length = 32, nullable = false)
    private String status;
    //тут связи будут

    public Table(int seats, String status) {
        this.seats = seats;
        this.status = status;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Table() {

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