package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.CoffeeDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeService<ID> {
        CoffeeDto register(CoffeeDto coffee);

        void expel(CoffeeDto coffee);

        void expel(ID id);

        Optional<CoffeeDto> findCoffee(ID id);

        List<CoffeeDto> getAll();


    CoffeeDto updateCoffee(Integer id, Optional<CoffeeDto> updatedCoffee);
}
