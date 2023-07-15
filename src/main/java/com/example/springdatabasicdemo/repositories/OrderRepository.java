package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Desk;
import com.example.springdatabasicdemo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
}
