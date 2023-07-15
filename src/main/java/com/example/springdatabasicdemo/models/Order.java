package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Order")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Order extends BaseEntity
{

    @Column(name = "Timestamp", nullable = false)
    private java.sql.Timestamp timestamp;
    @Column(name = "Status", length = 32, nullable = false)
    private String status;
    @Column(name = "Type", length = 32, nullable = false)
    private String type;
    //тут связи будут

    public Order(java.sql.Timestamp timestamp, String status, String type) {
        this.timestamp = timestamp;
        this.status = status;
        this.type = type;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Order() {

    }

    //Геттеры
    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    //Сеттеры
    private void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private void setType(String type) {
        this.type = type;
    }

}