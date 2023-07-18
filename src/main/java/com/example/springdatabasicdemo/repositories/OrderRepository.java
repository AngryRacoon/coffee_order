package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Customer;
import com.example.springdatabasicdemo.models.Desk;
import com.example.springdatabasicdemo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByCoffeesCoffeeId(Integer coffeeId);

    List<Order> findByCustomer_Id(Integer customerId);

    List<Order> findByDesk_Id(Integer deskId);

    List<Order> findByBarista_Id(Integer baristaId);

    List<Order> findByBaristaIdAndStatus(Integer baristaId, String status);
    @Query("SELECT o FROM Order o")
    List<Order> findAllOrders();
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(@Param("status") String status);
    @Query("SELECT o FROM Order o WHERE o.customer = :customer")
    List<Order> findByCustomer(@Param("customer") Customer customer);
    @Modifying
    @Query("UPDATE Order o SET o.status = :newStatus WHERE o.id = :id")
    void updateOrderStatus(@Param("id") Integer id, @Param("newStatus") String newStatus);
    @Modifying
    @Query("DELETE FROM Order o WHERE o.id = :id")
    void deleteOrderById(@Param("id") Integer id);

}
