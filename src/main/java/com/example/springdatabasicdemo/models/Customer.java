package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "Customer")
public  class Customer extends BaseEntity
{

    @Column(name = "Name", length = 32, nullable = false)
    private String name;
    @Column(name = "PhoneNumber", length = 12, nullable = false)
    private long phoneNumber;
    @Column(name = "Bonus")
    private long bonus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order> orders;

    //тут связи будут

    public Customer(String name, long phoneNumber,long bonus) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bonus = bonus;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Customer() {

    }

    //Геттеры
    public String getName() {
        return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public long getBonus() {
        return bonus;
    }

    //Сеттеры
    private void setName(String name) {
        this.name = name;
    }
    private void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    private void setBonus(long bonus) {
        this.bonus = bonus;
    }



}