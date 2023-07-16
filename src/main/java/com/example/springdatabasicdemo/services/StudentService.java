package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;

import java.util.List;
import java.util.Optional;

public interface StudentService<ID> {

    OrderDto register(OrderDto student);

    void expel(OrderDto student);

    void expel(ID id);

    void transfer(OrderDto student, CoffeeDto group);

    Optional<OrderDto> findStudent(ID id);

    List<OrderDto> getAll();

    List<OrderDto> findStudentsByGroup(String group);
}

