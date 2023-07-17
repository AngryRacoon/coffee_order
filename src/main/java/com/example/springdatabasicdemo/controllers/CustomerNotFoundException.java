package com.example.springdatabasicdemo.controllers;

public class CustomerNotFoundException extends RuntimeException {
    CustomerNotFoundException(Integer id) {super("Could not find customer " + id);}
}
