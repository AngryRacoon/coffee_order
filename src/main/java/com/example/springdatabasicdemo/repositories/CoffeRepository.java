package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Coffe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeRepository extends JpaRepository<Coffe, Integer>
{


}
