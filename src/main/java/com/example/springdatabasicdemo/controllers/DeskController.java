package com.example.springdatabasicdemo.controllers;
import com.example.springdatabasicdemo.dtos.DeskDto;
import com.example.springdatabasicdemo.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeskController {
    @Autowired
    private DeskService deskService;
    @GetMapping("/desks")
    Iterable<DeskDto> all() {
        return deskService.getAll();
    }

    @PostMapping("/desk")
    DeskDto newDesk(@RequestBody DeskDto newDesk)
    {  return deskService.register(newDesk); }

    @GetMapping("/desk/{id}")
    DeskDto one(@PathVariable Integer id) throws Throwable
    {

        return (DeskDto) deskService.findDesk(id)
                .orElseThrow(() -> new DeskNotFoundException(id));
    }
}
