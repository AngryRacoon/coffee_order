package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService<ID> {

    OrderDto register(OrderDto order);


    void expel(ID id);

    Optional<OrderDto> findOrder(ID id);

    List<OrderDto> getAll();


    List<OrderDto> findOrderByCoffee(Integer coffeeId);

    List<OrderDto> findOrderByCustomer(Integer customerId);

    List<OrderDto> findOrderByBarista(Integer baristaId);

    List<OrderDto> findOrderByBaristaIDStatus(Integer baristaId, String status);

    List<OrderDto> findOrderByDesk(Integer deskId);
}
