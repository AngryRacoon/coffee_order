package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService <Integer> {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private OrderCoffeRepository orderCoffeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeskRepository deskRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderDto register(OrderDto order,List<CoffeeDto> coffeesDto,Integer count) {
        Order o = modelMapper.map(order, Order.class);

        if (order.getBarista().getId() != 0) {
            Barista b = baristaRepository.findById(order.getBarista().getId()).get();
            o.setBarista(b);
        }

        o = orderRepository.save(o);
        List<OrderCoffee> orderCoffees  = new ArrayList<>();
        for (CoffeeDto coffeeDto : coffeesDto){
            Coffee coffee = modelMapper.map(coffeeDto, Coffee.class);
            OrderCoffee orderCoffee = new OrderCoffee();
            orderCoffee.setOrder(o);
            CoffeeOrderKey coffeeOrderKey = new CoffeeOrderKey(o.getId(), coffee.getId());
            orderCoffee.setId(coffeeOrderKey);
            orderCoffee.setCoffee(coffee);
            orderCoffee.setCount(count);
            orderCoffees.add(orderCoffee);
        }
        orderCoffeeRepository.saveAll(orderCoffees);
        return modelMapper.map(order, OrderDto.class);
    }




    @Override
    public void expel(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<OrderDto> findOrder(Integer id) {
        return Optional.ofNullable(modelMapper.map(orderRepository.findById(id),
                OrderDto.class));

    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream().map((s) ->
                modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());

    }


    @Override
    public List<OrderDto> findOrderByCoffee(Integer coffeeId) {
        return orderRepository.findByCoffeesCoffeeId(coffeeId).stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByCustomer(Integer customerId) {
        List<Order> orders = orderRepository.findByCustomer_Id(customerId);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByBarista(Integer baristaId) {
        List<Order> orders = orderRepository.findByBarista_Id(baristaId);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByBaristaIDStatus(Integer baristaId, String status) {
        List<Order> orders = orderRepository.findByBaristaIdAndStatus(baristaId, status);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByDesk(Integer deskId) {
        List<Order> orders = orderRepository.findByDesk_Id(deskId);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }
}
