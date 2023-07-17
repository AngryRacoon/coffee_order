package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.CustomerDto;
import com.example.springdatabasicdemo.dtos.OrderDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService<ID> {

    CustomerDto register(CustomerDto customer);

    void expel(CustomerDto customer);

    void expel(ID id);


    Optional<CustomerDto> findCustomer(ID id);

    List<CustomerDto> getAll();


}

