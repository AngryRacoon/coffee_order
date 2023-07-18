package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    Iterable<OrderDto> all() {
        return orderService.getAll();
    }

    @PostMapping("/order")
    OrderDto newOrder(@RequestBody OrderDto newOrder,@RequestParam List<CoffeeDto> coffees, @RequestParam Integer count)
    {  newOrder.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return orderService.register(newOrder,  coffees, count ); }

    @GetMapping("/order/{id}")
    OrderDto one(@PathVariable Integer id) throws Throwable
    {

        return (OrderDto) orderService.findOrder(id)
                .orElseThrow(() -> new DeskNotFoundException(id));
    }
    @DeleteMapping("/order/{id}")
    void deleteDesk(@PathVariable Integer id) {
        orderService.expel(id);
    }
}
