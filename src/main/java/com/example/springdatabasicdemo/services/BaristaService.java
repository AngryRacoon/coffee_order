package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BaristaDto;
import com.example.springdatabasicdemo.dtos.OrderDto;


import java.util.List;
import java.util.Optional;

public interface BaristaService<ID> {

    BaristaDto register(BaristaDto barista);

    void expel(BaristaDto barista);

    void expel(ID id);

    Optional<BaristaDto> findBarista(ID id);

    List<BaristaDto> getAll();

}

