package com.example.springdatabasicdemo.controllers;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(Integer id) {super("Could not find coffee " + id);}
}
