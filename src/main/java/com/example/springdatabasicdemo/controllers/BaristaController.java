package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BaristaDto;
import com.example.springdatabasicdemo.dtos.OrderDto;
import com.example.springdatabasicdemo.models.Barista;
import com.example.springdatabasicdemo.services.BaristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaristaController {
    @Autowired
    private BaristaService baristaService;
    @GetMapping("/baristas")
    Iterable<BaristaDto> all() {
        return baristaService.getAll();
    }

    @PostMapping("/barista")
    BaristaDto newBarista(@RequestBody BaristaDto newBarista)
    {  return baristaService.register(newBarista); }

    @GetMapping("/barista/{id}")
    BaristaDto one(@PathVariable Integer id) throws Throwable
    {

        return (BaristaDto) baristaService.findBarista(id)
                .orElseThrow(() -> new BaristaNotFoundException(id));
    }
    @DeleteMapping("/baristas/{id}")
    void deleteBarista(@PathVariable Integer id) {
        baristaService.expel(id);
    }
}
