package com.backend.javabackend.service;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.entity.Fanfic;
import com.backend.javabackend.mapper.FanficMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.javabackend.repository.FanficRepository;

import java.util.List;

@Service
public class FanficService {

    @Autowired
    private FanficRepository repository;

    public FanficDto saveFanfic(FanficDto fanficDto) {
        return fanficToDto(repository.save(fanficDtoToFanfic(fanficDto)));
    }

    public List<FanficDto> saveALl(List<FanficDto> fanficsDto) {
        return fanficsToDto(repository.saveAll(fanficsDtoToFanfics(fanficsDto)));
    }

    public FanficDto getFanficById(int id) {
        return fanficToDto(repository.findById(id).orElse(null));
    }

    public FanficDto getFanficByAuthor(String name) {

        return fanficToDto(repository.findByAuthor(name));
    }

    public List<FanficDto> getFanfics() {
        return fanficsToDto(repository.findAll());
    }

    public List<FanficDto> getAllByAuthor(String name) {
        return fanficsToDto(repository.findAllByAuthor(name));
    }

    public List<FanficDto> getAllByGenre(String genre) {
        return fanficsToDto(repository.findAllByGenre(genre));
    }

    public List<FanficDto> getAllByFandom(String fandom) {
        return fanficsToDto(repository.findAllByFandom(fandom));
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "Fanfic ID: " + id + " deleted";
    }

    public FanficDto updateFanfic(FanficDto fanficDto) {
        Fanfic fanfic = fanficDtoToFanfic(fanficDto);
        Fanfic curr = repository.findById(fanfic.getId()).orElse(null);
        curr.setId(fanfic.getId());
        curr.setName(fanfic.getName());
        curr.setAuthor(fanfic.getAuthor());
        curr.setGenre(fanfic.getGenre());
        curr.setFandom(fanfic.getFandom());
        curr.setRating(fanfic.getRating());
        curr.setQuantityRatings(fanfic.getQuantityRatings());
        curr.setAvgRating(fanfic.getAvgRating());
        return fanficToDto(repository.save(curr));

    }

    private FanficDto fanficToDto(Fanfic fanfic) {
        return FanficMapper.INSTANCE.fanficDto(fanfic);
    }

    private List<FanficDto> fanficsToDto(List<Fanfic> fanfics) {
        return FanficMapper.INSTANCE.fanficsToDto(fanfics);
    }

    private Fanfic fanficDtoToFanfic(FanficDto fanficDto){
        return FanficMapper.INSTANCE.fanficDtoToFanfic(fanficDto);
    }

    private List<Fanfic> fanficsDtoToFanfics(List<FanficDto> fanficsDto) {
        return FanficMapper.INSTANCE.fanficsDtoToFanfics(fanficsDto);
    }


}