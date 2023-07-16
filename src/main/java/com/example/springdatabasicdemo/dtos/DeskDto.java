package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;

public class DeskDto {

    private int id;
    private int seats;
    private String status;


    public DeskDto(int id, int seats, String status) {
        this.id = id;
        this.seats = seats;
        this.status = status;
    }

    public DeskDto() {
    }

    //Геттеры
    public int getId() {
        return id;
    }
    public int getSeats() {
        return seats;
    }

    public String getStatus() {
        return status;
    }

    /*public DeskDto getCoffee() {
        return coffee;
    }
*/

    //Сеттеры
    private void setId(int id) {
        this.id = id;
    }
    private void setSeats(int seats) {
        this.seats = seats;
    }

    private void setStatus(String status) {
        this.status = status;
    }

   /* public void setGroup(DeskDto group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

    */
}
