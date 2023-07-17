package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.DeskDto;

import java.util.List;
import java.util.Optional;

public interface DeskService<ID> {

    DeskDto register(DeskDto student);

    void expel(DeskDto student);

    void expel(ID id);


    Optional<DeskDto> findDesk(ID id);

    List<DeskDto> getAll();

}
