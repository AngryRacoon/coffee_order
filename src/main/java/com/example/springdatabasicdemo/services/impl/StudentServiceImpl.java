package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.GroupDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Coffe;
import com.example.springdatabasicdemo.models.Order_Coffe;
import com.example.springdatabasicdemo.repositories.CoffeRepository;
import com.example.springdatabasicdemo.repositories.Order_CoffeRepository;
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
    public StudentDto register(StudentDto student) {
        Order_Coffe s = modelMapper.map(student, Order_Coffe.class);
        if (student.getGroup().getId() != 0) {
            Coffe g = coffeRepository.findById(student.getGroup().getId()).get();
            s.setGroup(g);
        }
        return modelMapper.map(studentRepository.save(s), StudentDto.class);
    }

    @Override
    public void expel(StudentDto student) {
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void expel(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void transfer(StudentDto student, GroupDto group) {
        Order_Coffe s = studentRepository.findById(student.getId()).get();
        Coffe g = coffeRepository.findById(group.getId()).get();
        s.setGroup(g);
        studentRepository.save(s);
    }

    @Override
    public Optional<StudentDto> findStudent(Integer id) {
        return Optional.ofNullable(modelMapper.map(studentRepository.findById(id), StudentDto.class));
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findStudentsByGroup(String group) {
        return studentRepository.findAllByGroupName(group).stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }
}