package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.CoffeeDto;

import com.example.springdatabasicdemo.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;
    @GetMapping("/coffees")
    Iterable<CoffeeDto> all() {
        return coffeeService.getAll();
    }

    @PostMapping("/coffee")
    CoffeeDto newCoffee(@RequestBody CoffeeDto newCoffee)
    {  return coffeeService.register(newCoffee); }

    @GetMapping("/coffee/{id}")
    CoffeeDto one(@PathVariable Integer id) throws Throwable
    {

        return (CoffeeDto) coffeeService.findCoffee(id)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
    }
    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable Integer id) {
        coffeeService.expel(id);
    }



}
