package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.DeskDto;
import com.example.springdatabasicdemo.models.Desk;
import com.example.springdatabasicdemo.repositories.DeskRepository;
import com.example.springdatabasicdemo.repositories.OrderRepository;
import com.example.springdatabasicdemo.services.DeskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeskServiceImpl implements DeskService<Integer> {
    @Autowired
    private DeskRepository deskRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeskDto register(DeskDto desk) {
        Desk d = modelMapper.map(desk, Desk.class);
        return modelMapper.map(deskRepository.save(d), DeskDto.class);
    }

    @Override
    public void expel(DeskDto desk) {
        deskRepository.deleteById(desk.getId());
    }

    @Override
    public void expel(Integer id) {
        deskRepository.deleteById(id);
    }

    @Override
    public Optional<DeskDto> findDesk(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<DeskDto> getAll() {
        return deskRepository.findAll().stream().map((d) ->
                modelMapper.map(d, DeskDto.class)).collect(Collectors.toList());
    }
}
