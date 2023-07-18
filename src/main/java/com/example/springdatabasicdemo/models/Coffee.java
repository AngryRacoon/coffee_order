package com.example.springdatabasicdemo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Coffee")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public  class Coffee extends BaseEntity
{

    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "discription",  nullable = false)
    private String discription;
    @Column(name = "price",  nullable = false)
    private BigDecimal price;
    @Column(name = "ingredients",  nullable = false)
    private String ingredients;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coffee")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<OrderCoffee> orders;

    public Coffee(String name, String description, BigDecimal price,String ingredients) {
        this.name = name;
        this.discription = description;
        this.price = price;
        this.ingredients = ingredients;
        this.orders = new HashSet<>();
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Coffee(){

    }
    public Set<OrderCoffee> getOrders() {
        return orders;
    }
    public void setOrders(Set<OrderCoffee> orders) {
        this.orders = orders;
    }
    //Геттеры
    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getIngredients() {
        return ingredients;
    }

    //Сеттеры
    private void setName(String name) {
        this.name = name;
    }
    private void setDiscription(String discription) {
        this.discription = discription;
    }
    private void setPrice(BigDecimal price) {
        this.price = price;
    }
    private void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }



/*
    public Set<Order_Coffee> getStudents() {
        return students;
    }

    public void setStudents(Set<Order_Coffee> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name + " }";
    } */
}
