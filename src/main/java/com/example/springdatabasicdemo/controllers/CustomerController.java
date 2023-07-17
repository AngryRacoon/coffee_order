package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BaristaDto;
import com.example.springdatabasicdemo.dtos.CustomerDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.services.BaristaService;
import com.example.springdatabasicdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    Iterable<CustomerDto> all() {
        return customerService.getAll();
    }

    @PostMapping("/customer")
    CustomerDto newCustomer(@RequestBody CustomerDto newCustomer)
    {  return customerService.register(newCustomer); }

    @GetMapping("/customer/{id}")
    CustomerDto one(@PathVariable Integer id) throws Throwable
    {

        return (CustomerDto) customerService.findCustomer(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
