package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

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

        BaristaDto b2 = new BaristaDto(1, "Pasha", 10, BigDecimal.valueOf(23000), 797734648);
        b2 = baristaService.register(b1);
        BaristaDto b3 = new BaristaDto(2, "Alex", 5, BigDecimal.valueOf(18000), 797765432);
        b3 = baristaService.register(b3);

        BaristaDto b4 = new BaristaDto(3, "Anna", 3, BigDecimal.valueOf(15000), 797712345);
        b4 = baristaService.register(b4);

        BaristaDto b5 = new BaristaDto(4, "Max", 2, BigDecimal.valueOf(14000), 797723456);
        b5 = baristaService.register(b5);

        BaristaDto b6 = new BaristaDto(5, "Olga", 7, BigDecimal.valueOf(20000), 797734567);
        b6 = baristaService.register(b6);

        BaristaDto b7 = new BaristaDto(6, "Ivan", 4, BigDecimal.valueOf(16000), 797745678);
        b7 = baristaService.register(b7);


        CoffeeDto c1 = new CoffeeDto(0,"Late","Raspberry latte is a beverage made with hot milk and espresso", BigDecimal.valueOf(250),"Milk,Coffee");
        c1 = coffeeService.register(c1);
        CoffeeDto c2 = new CoffeeDto(1, "Cappuccino", "A coffee-based drink made with espresso and steamed milk", BigDecimal.valueOf(280), "Coffee, Milk");
        c2 = coffeeService.register(c2);

        CoffeeDto c3 = new CoffeeDto(2, "Espresso", "A concentrated coffee beverage brewed by forcing hot water under pressure", BigDecimal.valueOf(200), "Coffee");
        c3 = coffeeService.register(c3);

        CoffeeDto c4 = new CoffeeDto(3, "Matcha", "A chocolate-flavored coffee beverage with espresso and steamed milk", BigDecimal.valueOf(300), "Coffee, Milk, Chocolate");
        c4 = coffeeService.register(c4);

        CoffeeDto c5 = new CoffeeDto(4, "Americano", "A diluted espresso drink made by adding hot water to espresso", BigDecimal.valueOf(220), "Coffee, Water");
        c5 = coffeeService.register(c5);

        CoffeeDto c6 = new CoffeeDto(5, "Macchiato", "An espresso coffee drink with a small amount of milk foam on top", BigDecimal.valueOf(260), "Coffee, Milk Foam");
        c6 = coffeeService.register(c6);

        CustomerDto cs1 = new CustomerDto(0,"Pavel",796234648);
        cs1 = customerService.register(cs1);
        CustomerDto cs2 = new CustomerDto(1, "Anna", 797734648);
        cs2 = customerService.register(cs2);

        CustomerDto cs3 = new CustomerDto(2, "Max", 797712345);
        cs3 = customerService.register(cs3);

        CustomerDto cs4 = new CustomerDto(3, "Olga", 797723456);
        cs4 = customerService.register(cs4);

        CustomerDto cs5 = new CustomerDto(4, "Ivan", 797734567);
        cs5 = customerService.register(cs5);

        CustomerDto cs6 = new CustomerDto(5, "Elena", 797745678);
        cs6 = customerService.register(cs6);


        DeskDto d1 = new DeskDto(0,1,"table is free");
        d1 = deskService.register(d1);

        DeskDto d2 = new DeskDto(1,5,"table is free");
        d2 = deskService.register(d2);
        DeskDto d3 = new DeskDto(2,3,"table is free");
        d3 = deskService.register(d3);
    }
}
