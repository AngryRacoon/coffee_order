package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CoffeeDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Coffee;
import com.example.springdatabasicdemo.repositories.CoffeRepository;
import com.example.springdatabasicdemo.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService<Integer> {

    @Autowired
    private Order_CoffeRepository studentRepository;

    @Autowired
    private CoffeRepository coffeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto register(OrderDto student) {
        Order_Coffee s = modelMapper.map(student, Order_Coffee.class);
        if (student.getGroup().getId() != 0) {
            Coffee g = coffeRepository.findById(student.getGroup().getId()).get();

        }
        return modelMapper.map(studentRepository.save(s), OrderDto.class);
    }

    @Override
    public void expel(OrderDto student) {
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void expel(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void transfer(OrderDto student, CoffeeDto group) {
        Order_Coffee s = studentRepository.findById(student.getId()).get();
        Coffee g = coffeRepository.findById(group.getId()).get();
        s.setGroup(g);
        studentRepository.save(s);
    }

    @Override
    public Optional<OrderDto> findStudent(Integer id) {
        return Optional.ofNullable(modelMapper.map(studentRepository.findById(id), OrderDto.class));
    }

    @Override
    public List<OrderDto> getAll() {
        return studentRepository.findAll().stream().map((s) -> modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findStudentsByGroup(String group) {
        return studentRepository.findAllByGroupName(group).stream().map((s) -> modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());
    }
}