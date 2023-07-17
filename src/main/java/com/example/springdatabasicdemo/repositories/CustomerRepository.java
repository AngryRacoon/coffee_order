package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query("SELECT c FROM Customer c")
    List<Customer> findAllCustomers();
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);
    @Modifying
    @Query("UPDATE Customer c SET c.name = :newName WHERE c.id = :id")
    void updateCustomerName(@Param("id") Integer id, @Param("newName") int newName);
    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = :id")
    void deleteCustomerById(@Param("id") Integer id);

}
