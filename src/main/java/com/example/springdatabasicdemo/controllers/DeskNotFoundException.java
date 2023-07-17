package com.example.springdatabasicdemo.controllers;

public class DeskNotFoundException extends RuntimeException {
    DeskNotFoundException(Integer id) {super("Could not find desk " + id);}
}
