package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;
import com.example.springdatabasicdemo.models.Order;

import java.math.BigDecimal;
import java.util.Set;

public class BaristaDto {

    private int id;
    private String name;
    private int rating;
    private BigDecimal salary;
    private long phone_number;
    private Set<Order> orders;


    public BaristaDto(int id, String name, int rating, BigDecimal salary, long phone_number) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.salary = salary;
        this.phone_number = phone_number;
        this.orders = orders;
    }

    public BaristaDto() {
    }

    //Геттеры
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public long getPhoneNumber() {
        return phone_number;
    }

    /*public BaristaDto getCoffee() {
        return coffee;
    }
*/

    //Сеттеры
    private void setId(int id) {
        this.id = id;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setPhoneNumber(long phone_number) {
        this.phone_number = phone_number;
    }
    private void setRating(int rating) {
        this.rating = rating;
    }
    private void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

   /* public void setGroup(BaristaDto group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

    */
}
