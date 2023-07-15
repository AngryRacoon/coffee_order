package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Customer extends BaseEntity
{

    @Column(name = "Name", length = 32, nullable = false)
    private String name;
    @Column(name = "PhoneNumber", length = 10, nullable = false)
    private long phoneNumber;
    @Column(name = "Bonus", length = 32, nullable = false)
    private String bonus;

    //тут связи будут

    public Customer(String name, long phoneNumber,String bonus) {
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
    public String getBonus() {
        return bonus;
    }

    //Сеттеры
    private void setName(String name) {
        this.name = name;
    }
    private void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    private void setBonus(String bonus) {
        this.bonus = bonus;
    }



}