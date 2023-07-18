package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.controllers.CoffeeNotFoundException;
import com.example.springdatabasicdemo.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CoffeeDto {
    private Long id;
    private String name;
    private String discription;
    private BigDecimal price;
    private String ingredients;
    public CoffeeDto(Long id, String name, String discription, BigDecimal price, String ingredients) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.ingredients = ingredients;
    }

    public CoffeeDto()
    {
    }
    //Геттеры
    public Long getId() {
        return id;
    }
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
    public void setName(String name) {
        this.name = name;
    }
      public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Coffe { id=" + id + ", name=" + name + " }";
    }
}
