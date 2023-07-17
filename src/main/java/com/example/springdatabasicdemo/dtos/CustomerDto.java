package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;

public class CustomerDto {

    private int id;
    private String name;

    private long phoneNumber;



    public CustomerDto(int id,String name, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public CustomerDto() {
    }

    //Геттеры
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }


    /*public CustomerDto getCoffee() {
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
    private void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


   /* public void setGroup(CustomerDto group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

    */
}
