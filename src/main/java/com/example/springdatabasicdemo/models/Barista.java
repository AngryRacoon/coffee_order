package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

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
    private String salary;
    @Column(name = "PhoneNumber", length = 12, nullable = false)
    private long phone_number;
    //тут связи будут
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barista")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order> orders;



    public Barista(String name, int rating,String salary, long phone_number) {
        this.name = name;
        this.rating = rating;
        this.salary = salary;
        this.phone_number = phone_number;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Barista() {

    }

    //Геттеры
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public String getSalary() {
        return salary;
    }
    public long getPhoneNumber() {
        return phone_number;
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
    private void setSalary(String salary) {
        this.salary = salary;
    }



}