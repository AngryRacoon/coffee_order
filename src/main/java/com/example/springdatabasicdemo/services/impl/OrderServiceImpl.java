package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Order;
import com.example.springdatabasicdemo.repositories.OrderRepository;
import com.example.springdatabasicdemo.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService <Integer> {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public OrderDto register(OrderDto order) {
        Order o = modelMapper.map(order, Order.class);
        return modelMapper.map(orderRepository.save(o), OrderDto.class);
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
