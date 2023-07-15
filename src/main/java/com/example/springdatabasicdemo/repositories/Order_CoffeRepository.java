package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Order_Coffe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Order_CoffeRepository extends JpaRepository<Order_Coffe, Integer> {
    List<Order_Coffe> findAllByGroupName(String groupName);
}
