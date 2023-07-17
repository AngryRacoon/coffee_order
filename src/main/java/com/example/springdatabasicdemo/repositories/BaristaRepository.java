package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Barista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaristaRepository extends JpaRepository<Barista, Integer>
{
    @Query("SELECT b FROM Barista b")
    List<Barista> findAllBaristas();
    @Query("SELECT b FROM Barista b WHERE b.name = :name")
    List<Barista> findByName(@Param("name") String name);
    @Modifying
    @Query("UPDATE Barista b SET b.name = :newName WHERE b.id = :id")
    void updateBaristaName(@Param("id") Integer id, @Param("newName") String newName);
    @Modifying
    @Query("DELETE FROM Barista b WHERE b.id = :id")
    void deleteBaristaById(@Param("id") Integer id);


}
