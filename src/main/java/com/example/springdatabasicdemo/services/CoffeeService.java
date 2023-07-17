package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Coffee;

import java.util.List;
import java.util.Optional;

public interface CoffeeService<ID> {
        CoffeeDto register(CoffeeDto coffee);

        void expel(CoffeeDto coffee);

        void expel(ID id);

        Optional<CoffeeDto> findCoffee(ID id);

        List<CoffeeDto> getAll();



}
