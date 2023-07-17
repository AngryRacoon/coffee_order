package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.BaristaDto;
import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.services.BaristaService;
import com.example.springdatabasicdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private BaristaService baristaService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }



    private void seedData() throws IOException {
        //Добавление в БД записей
        BaristaDto b1 = new BaristaDto(0, "Ivan", 7, "1200", 795234648);

        b1 = baristaService.register(b1);

    }
}
