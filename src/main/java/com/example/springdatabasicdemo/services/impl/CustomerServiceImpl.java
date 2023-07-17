package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CustomerDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.repositories.CustomerRepository;
import com.example.springdatabasicdemo.repositories.OrderRepository;
import com.example.springdatabasicdemo.services.CustomerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService<Integer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto register(CustomerDto customer) {
        Customer c = modelMapper.map(customer, Customer.class);
        return modelMapper.map(customerRepository.save(c), CustomerDto.class);
    }

    @Override
    public void expel(CustomerDto customer) {
        customerRepository.deleteById(customer.getId());
    }

    @Override
    public void expel(Integer id) {
        customerRepository.deleteById(id);
    }


    @Override
    public Optional<CustomerDto> findCustomer(Integer id) {
        return Optional.ofNullable(modelMapper.map(customerRepository.findById(id), CustomerDto.class));
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map((s) ->
                modelMapper.map(s, CustomerDto.class)).collect(Collectors.toList());
    }
}