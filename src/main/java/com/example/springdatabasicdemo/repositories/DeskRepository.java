package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface DeskRepository extends JpaRepository<Desk, Integer>{
    @Query("SELECT d FROM Desk d")
    List<Desk> findAllDesks();
    @Query("SELECT d FROM Desk d WHERE d.seats = :seats")
    List<Desk> findBySeats(@Param("seats") int seats);
    @Query("SELECT d FROM Desk d WHERE d.status = :status")
    List<Desk> findByStatus(@Param("status") String status);
    @Modifying
    @Query("UPDATE Desk d SET d.status = :newStatus WHERE d.id = :id")
    void updateDeskStatus(@Param("id") Integer id, @Param("newStatus") String newStatus);
    @Modifying
    @Query("DELETE FROM Desk d WHERE d.id = :id")
    void deleteDeskById(@Param("id") Integer id);



}
