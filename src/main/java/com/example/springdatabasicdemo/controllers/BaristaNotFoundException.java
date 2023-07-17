package com.example.springdatabasicdemo.controllers;

public class BaristaNotFoundException extends RuntimeException {
    BaristaNotFoundException(Integer id) {super("Could not find student " + id);}
}
