package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void printAllStudentsByGroupName(String groupName) {
        studentService
                .findStudentsByGroup(groupName)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        CoffeeDto g1 = new CoffeeDto(0,"UVP-211");
        CoffeeDto g2 = new CoffeeDto(0,"UVP-212");

        OrderDto s1 = new OrderDto(0, "Petr Ivanov", g1);
        OrderDto s2 = new OrderDto(0, "Ivan Petrov", g2);

        s1 = studentService.register(s1);
        s2 = studentService.register(s2);

        printAllStudentsByGroupName("UVP-212");

        studentService.transfer(s1, s2.getGroup());

        printAllStudentsByGroupName("UVP-212");
    }
}
