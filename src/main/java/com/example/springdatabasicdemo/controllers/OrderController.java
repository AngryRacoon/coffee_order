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
    OrderDto newOrder(@RequestBody OrderDto newOrder,
                      @RequestParam List<CoffeeDto> coffees,
                      @RequestParam Integer count)
    {
        return orderService.register(newOrder,  coffees, count ); }

    @GetMapping("/order/{id}")
    OrderDto one(@PathVariable Integer id) throws Throwable
    {

        return (OrderDto) orderService.findOrder(id)
                .orElseThrow(() -> new DeskNotFoundException(id));
    }
    @GetMapping("/order/barista/{id}")
    Iterable<OrderDto> two(@PathVariable Integer id) throws Throwable
    {

        return orderService.findOrderByBarista(id);
    }
    @GetMapping("/order/desk/{id}")
    Iterable<OrderDto> three(@PathVariable Integer id) throws Throwable
    {

        return orderService.findOrderByDesk(id);
    }
    @GetMapping("/order/customer/{id}")
    Iterable<OrderDto> four(@PathVariable Integer id) throws Throwable
    {

        return orderService.findOrderByCustomer(id);
    }
    @GetMapping("/order/barista/{id}/{status}")
    Iterable<OrderDto> five(@PathVariable Integer id, @PathVariable String status) throws Throwable
    {

        return orderService.findOrderByBaristaIDStatus(id, status);
    }
    @DeleteMapping("/order/{id}")
    void deleteDesk(@PathVariable Integer id) {
        orderService.expel(id);
    }
}
