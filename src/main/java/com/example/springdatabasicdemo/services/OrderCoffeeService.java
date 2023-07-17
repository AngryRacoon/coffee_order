package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OrderCoffeeDTO;

import java.util.List;
import java.util.Optional;

public interface OrderCoffeeService<ID> {

    OrderCoffeeDTO register(OrderCoffeeDTO orderCoffee);

    void expel(Integer coffeeId, Integer orderId);

    void updateOrderCoffee(OrderCoffeeDTO orderCoffeeDTO);

    OrderCoffeeDTO getOrderCoffeeById(Integer coffeeId, Integer orderId);

    List<OrderCoffeeDTO> getAll();


}
