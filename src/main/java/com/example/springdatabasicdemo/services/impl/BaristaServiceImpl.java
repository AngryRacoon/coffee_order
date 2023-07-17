package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BaristaDto;
import com.example.springdatabasicdemo.dtos.CustomerDto;
import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.repositories.BaristaRepository;
import com.example.springdatabasicdemo.services.BaristaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BaristaServiceImpl implements BaristaService<Integer> {
    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaristaDto register(BaristaDto barista) {
        Barista b = modelMapper.map(barista, Barista.class);
        return modelMapper.map(baristaRepository.save(b), BaristaDto.class);
    }

    @Override
    public void expel(BaristaDto barista) {
        baristaRepository.deleteById(barista.getId());
    }
    @Override
    public void expel(Integer id) {
        baristaRepository.deleteById(id);
    }



    @Override
    public Optional<BaristaDto> findBarista(Integer id) {
        return Optional.ofNullable(modelMapper.map(baristaRepository.findById(id), BaristaDto.class));
    }

    @Override
    public List<BaristaDto> getAll() {
        return baristaRepository.findAll().stream().map((b) ->
                modelMapper.map(b, BaristaDto.class)).collect(Collectors.toList());
    }


}

