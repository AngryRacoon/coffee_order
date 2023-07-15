package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Barista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaristaRepository extends JpaRepository<Barista, Integer> {
}
