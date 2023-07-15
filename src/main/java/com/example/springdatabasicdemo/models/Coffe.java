package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Coffe")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Coffe extends BaseEntity
{

    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "discription", length = 50, nullable = false)
    private String discription;
    @Column(name = "price", length = 50, nullable = false)
    private BigDecimal price;
    @Column(name = "ingredients",  nullable = false)
    private String ingredients;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order_Coffe> students;

    public Coffe(String name, String discription, BigDecimal price,String ingredients) {
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.ingredients = ingredients;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Coffe(){

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
    public Set<Order_Coffe> getStudents() {
        return students;
    }

    public void setStudents(Set<Order_Coffe> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name + " }";
    } */
}
