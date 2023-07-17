package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer>
{
    // Поиск кофе по Имени
    @Query("SELECT c FROM Coffee c")
    List<Coffee> findAllCoffee();
    @Query("SELECT c FROM Coffee c WHERE c.name = :name")
    List<Coffee> findByName(@Param("name") String name);

    @Query("SELECT c FROM Coffee c WHERE c.price <= :maxPrice")
    List<Coffee> findByPriceLessThanOrEqual(@Param("maxPrice") BigDecimal maxPrice);
    @Modifying
    @Query("UPDATE Coffee c SET c.price = :newPrice WHERE c.id = :id")
    void updateCoffeePrice(@Param("id") Integer id, @Param("newPrice") BigDecimal newPrice);
    @Modifying
    @Query("DELETE FROM Coffee c WHERE c.id = :id")
    void deleteCoffeeById(@Param("id") Integer id);



}
