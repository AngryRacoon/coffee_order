package com.example.springdatabasicdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CoffeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CoffeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String coffeeNotFoundHandler(CoffeeNotFoundException ex) {
        return ex.getMessage();
    }
}
