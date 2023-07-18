package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OrderCoffeeDTO;
import com.example.springdatabasicdemo.models.OrderCoffee;
import com.example.springdatabasicdemo.repositories.OrderCoffeRepository;
import com.example.springdatabasicdemo.repositories.OrderRepository;
import com.example.springdatabasicdemo.services.OrderCoffeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCoffeeServiceImpl implements OrderCoffeeService<Integer> {
    @Autowired
    private OrderCoffeRepository orderCoffeRepository;

    private List<OrderCoffeeDTO> orderCoffees = new ArrayList<>();

    @Override
    public OrderCoffeeDTO register (OrderCoffeeDTO orderCoffeeDTO) {
        orderCoffees.add(orderCoffeeDTO);
        return orderCoffeeDTO;
    }

    @Override
    public OrderCoffeeDTO getOrderCoffeeById(Integer coffeeId, Integer orderId) {
        for (OrderCoffeeDTO orderCoffee : orderCoffees) {
            if (orderCoffee.getCoffee().equals(coffeeId) && orderCoffee.getOrder().equals(orderId)) {
                return orderCoffee;
            }
        }
        return null;
    }

    @Override
    public List<OrderCoffeeDTO> getAll() {
        return orderCoffees;
    }

    @Override
    public void updateOrderCoffee(OrderCoffeeDTO orderCoffeeDTO) {
        for (OrderCoffeeDTO orderCoffee : orderCoffees) {
            if (orderCoffee.getCoffee().equals(orderCoffeeDTO.getCoffee()) &&
                    orderCoffee.getOrder().equals(orderCoffeeDTO.getOrder())) {
                orderCoffee.setCount(orderCoffeeDTO.getCount());
                break;
            }
        }
    }

    @Override
    public void expel(Integer coffeeId, Integer orderId) {
        orderCoffees.removeIf(orderCoffee -> orderCoffee.getCoffee().equals(coffeeId) &&
                orderCoffee.getOrder().equals(orderId));
    }
}
