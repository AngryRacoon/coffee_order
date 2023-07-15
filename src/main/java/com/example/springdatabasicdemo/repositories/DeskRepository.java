package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Integer>{
}
