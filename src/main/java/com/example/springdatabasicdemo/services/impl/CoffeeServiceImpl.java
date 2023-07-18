package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.CustomerDto;
import com.example.springdatabasicdemo.repositories.CoffeeRepository;
import com.example.springdatabasicdemo.repositories.OrderRepository;
import com.example.springdatabasicdemo.services.CoffeeService;
import com.example.springdatabasicdemo.models.Coffee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffeeServiceImpl implements CoffeeService <Integer> {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CoffeeDto register(CoffeeDto coffee) {
        Coffee c = modelMapper.map(coffee, Coffee.class);
        return modelMapper.map(coffeeRepository.save(c), CoffeeDto.class);
    }

    @Override
    public void expel(CoffeeDto coffee) {
        coffeeRepository.deleteById(Math.toIntExact(coffee.getId()));
    }

    @Override
    public void expel(Integer id) {
        coffeeRepository.deleteById(id);
    }


    @Override
    public Optional<CoffeeDto> findCoffee(Integer id) {
        return Optional.ofNullable(modelMapper.map(coffeeRepository.findById(id), CoffeeDto.class));
    }

    @Override
    public List<CoffeeDto> getAll() {
        return coffeeRepository.findAll().stream().map((c) ->
                modelMapper.map(c, CoffeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public CoffeeDto updateCoffee(Integer id, Optional<CoffeeDto> updatedCoffee) {
        return null;
    }


}

