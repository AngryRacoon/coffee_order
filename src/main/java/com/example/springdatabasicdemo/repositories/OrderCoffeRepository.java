package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.OrderCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCoffeRepository extends JpaRepository<OrderCoffee, Integer>{
}
// НЕ ВИДИТ КЛАСС OrderCoffee