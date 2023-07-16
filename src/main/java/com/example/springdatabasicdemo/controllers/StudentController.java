package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    Iterable<OrderDto> all() {
        return studentService.getAll();
    }

    @PostMapping("/students")
    OrderDto newStudent(@RequestBody OrderDto newStudent)
    {  return studentService.register(newStudent); }

    @GetMapping("/students/{id}")
    OrderDto one(@PathVariable Integer id) throws Throwable
    {

        return (OrderDto) studentService.findStudent(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Integer id)
    {
        studentService.expel(id);
    }
}
