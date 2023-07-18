package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private BaristaService baristaService;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DeskService deskService;
    @Autowired
    private OrderService orderService;
    @Override
    public void run(String... args) throws Exception {
        seedData();
    }



    private void seedData() throws IOException {
        //Добавление в БД записей
        BaristaDto b1 = new BaristaDto(0, "Ivan", 7, BigDecimal.valueOf(19000), 795234648);
        b1 = baristaService.register(b1);
        CoffeeDto c1 = new CoffeeDto(0L,"Late","Raspberry latte is a beverage made with hot milk and espresso", BigDecimal.valueOf(250),"Milk,Coffee");
        c1 = coffeeService.register(c1);

        CustomerDto cs1 = new CustomerDto(0,"Pavel",796234648);
        cs1 = customerService.register(cs1);

        DeskDto d1 = new DeskDto(0,1,"table is free");
        d1 = deskService.register(d1);

        OrderDto o = new OrderDto(0, cs1, d1, b1, new Timestamp(System.currentTimeMillis()), "done",false );
        List<CoffeeDto> cf = new ArrayList<>();
        cf.add(c1);
        o = orderService.register(o,cf , 1);
    }
}
