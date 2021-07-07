package com.backend.javabackend.controller;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.dto.FanficDtoShort;
import com.backend.javabackend.repository.SearchRepo;
import com.backend.javabackend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.backend.javabackend.service.FanficService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://fanfic-web.herokuapp.com")
public class FanficController {

    @Autowired
    private FanficService service;

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/{word}")
    public List<FanficDto> searchByWord(@PathVariable String word){
        return searchService.findWordInText(word);
    }

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

    @GetMapping("/fanficsPaged")
    public Page<FanficDto> findAll(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
            ) {
        return service.getFanficsPaged(page, sortBy);
    }

    @GetMapping("/fanfics")
    public List<FanficDto> findAll(){
        return service.getFanfics();
    }


    @GetMapping("/fanficsSorted")
    public List<FanficDto> findAll(@RequestParam String ordering){
        return service.findAllSorted(ordering);
    }

    @GetMapping("/fanficByName/{name}")
    public FanficDto findFanficByAuthor(@PathVariable String name) {
        return service.getFanficByAuthor(name);
    }

    @GetMapping("/fanfics/findAllByAuthor/{name}")
    public List<FanficDto> findAllByAuthor(@PathVariable String name) {
        return service.getAllByAuthor(name);
    }

    @GetMapping("/fanfics/findAllByGenre/{genre}")
    public List<FanficDto> findAllByGenre(@PathVariable String genre){
        return service.getAllByGenre(genre);
    }

    @GetMapping("/fanfics/findAllByFandom/{fandom}")
    public List<FanficDto> findAllByFandom(@PathVariable String fandom){
        return service.getAllByFandom(fandom);
    }

    @GetMapping("/short/findShortFanficById/{id}")
    public FanficDtoShort findShortFanficById(@PathVariable int id){
        return service.getFanficByIdShort(id);
    }

    @GetMapping("/short/findShortByName/{name}")
    public FanficDtoShort findShortFanficByAuthor(@PathVariable String name){
        return service.getFanficByAuthorShort(name);
    }

    @GetMapping("/short/findAllByAuthor/{name}")
    public List<FanficDtoShort> findAllByAuthorShort(@PathVariable String name) {

        return service.getAllByAuthorShort(name);
    }

    @GetMapping("/short/all")
    public List<FanficDtoShort> findAllShort() {
        return service.getFanficsShort();
    }

    @GetMapping("/short/findAllByGenre/{genre}")
    public List<FanficDtoShort> findAllByGenreShort(@PathVariable String genre){

        return service.getAllByGenreShort(genre);
    }

    @GetMapping("/short/findAllByFandom/{fandom}")
    public List<FanficDtoShort> findAllByFandomShort(@PathVariable String fandom){
        return service.getAllByFandomShort(fandom);
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
