package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.dtos.OrderCoffeeDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public  class Order extends BaseEntity
{
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable=false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barista_id", referencedColumnName = "id", nullable=false)
    private Barista barista;

    @ManyToOne(optional = false)
    @JoinColumn(name = "desk_id", referencedColumnName = "id", nullable=false)
    private Desk desk;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<OrderCoffee> coffees;

    @Column(name = "Timestamp", nullable = false)
    private java.sql.Timestamp timestamp;
    @Column(name = "Status", length = 32, nullable = false)
    private String status;
    @Column(name = "Type", length = 32, nullable = false)
    private boolean type;
    //тут связи будут


    public Order(Customer customer, Barista barista, Desk desk,  Timestamp timestamp, String status, boolean type) {
        this.customer = customer;
        this.barista = barista;
        this.desk = desk;
        this.coffees = new HashSet<>();
        this.timestamp = timestamp;
        this.status = status;
        this.type = type;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Order() {

    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }

    public Set<OrderCoffee> getCoffees() {
        return coffees;
    }
    private void setCoffees(Set<OrderCoffee>coffees){this.coffees = coffees;}

    //Геттеры
    public Timestamp getTimestamp() {
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