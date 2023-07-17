package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer>
{


}
