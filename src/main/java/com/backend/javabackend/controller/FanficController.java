package com.backend.javabackend.controller;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.entity.Fanfic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.javabackend.service.FanficService;

import java.util.List;

@RestController
public class FanficController {

    @Autowired
    private FanficService service;

    @PostMapping("/addFanfic")
    public FanficDto addFanfic(@RequestBody FanficDto fanficDto) {
        return service.saveFanfic(fanficDto);
    }

    @PostMapping("/addFanfics")
    public List<FanficDto> addFanfics(@RequestBody List<FanficDto> fanficsDto) {
        return service.saveALl(fanficsDto);
    }

    @GetMapping("/fanfic/{id}")
    public FanficDto findFanficById(@PathVariable int id) {
        return service.getFanficById(id);
    }

    @GetMapping("/fanfics")
    public List<FanficDto> findAll() {
        return service.getFanfics();
    }

    @GetMapping("/fanficByName/{name}")
    public FanficDto findFanficByAuthor(@PathVariable String name) {
        return service.getFanficByAuthor(name);
    }

    @GetMapping("/fanfics/{name}")
    public List<FanficDto> findAllByAuthor(@PathVariable String name) {
        return service.getAllByAuthor(name);
    }

    @GetMapping("/fanfics/{genre}")
    public List<FanficDto> findAllByGenre(@PathVariable String genre){
        return service.getAllByGenre(genre);
    }

    @GetMapping("/fanfics/{fandom}")
    public List<FanficDto> findAllByFandom(@PathVariable String fandom){
        return service.getAllByFandom(fandom);
    }

    @PutMapping("/update")
    public FanficDto updateFanfic(@RequestBody FanficDto fanfic) {
        return service.updateFanfic(fanfic);
    }

    @DeleteMapping("/deleteFanfic/{id}")
    public String deleteFanfic(@PathVariable int id){
        return service.deleteById(id);

    }




}
