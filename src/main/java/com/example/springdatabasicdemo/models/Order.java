package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Order extends BaseEntity
{

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barista_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Barista barista;

    @ManyToOne(optional = false)
    @JoinColumn(name = "desk_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Desk desk;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    Set<OrderCoffee> coffees;


    @Column(name = "Timestamp", nullable = false)
    private java.sql.Timestamp timestamp;
    @Column(name = "Status", length = 32, nullable = false)
    private String status;
    @Column(name = "Type", length = 32, nullable = false)
    private boolean type;
    //тут связи будут


    public Order(java.sql.Timestamp timestamp, String status, boolean type) {
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

    public boolean getType() {
        return type;
    }

    //Сеттеры
    private void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private void setType(boolean type) {
        this.type = type;
    }

}