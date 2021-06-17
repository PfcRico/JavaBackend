package com.backend.javabackend.service;

import com.backend.javabackend.customexception.BusinessException;
import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.dto.FanficDtoShort;
import com.backend.javabackend.entity.Fanfic;
import com.backend.javabackend.mapper.FanficMapper;
import com.backend.javabackend.mapper.FanficShortMapper;
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
        if (id < 0){
            throw new BusinessException ("400", "Fanfic not found", "ID is less than zero");
        } else if (repository.findById(id).orElse(null) == null){
            throw new BusinessException ("404", "Fanfic not found", "There isn't Fanfic with this ID in DB");
        }
        return fanficToDto(repository.findById(id).orElse(null));
    }

    public FanficDtoShort getFanficByIdShort(int id) {
        if (id < 0){
            throw new BusinessException ("400", "Fanfic not found", "ID is less than zero");
        } else if (repository.findById(id).orElse(null) == null){
            throw new BusinessException ("404", "Fanfic not found", "There isn't Fanfic with this ID in DB");
        }
        return fanficToDtoShort(repository.findById(id).orElse(null));
    }

    public FanficDto getFanficByAuthor(String name) {
        if (name.isEmpty()){
            throw new BusinessException ("400", "Fanfic not found", "Author name is empty");
        } else if (repository.findByAuthor(name) == null){
            throw new BusinessException ("404", "Fanfic not found", "There isn't Fanfic with this Author in DB");
        }
        return fanficToDto(repository.findByAuthor(name));
    }

    public FanficDtoShort getFanficByAuthorShort(String name) {
        if (name.isEmpty()){
            throw new BusinessException ("400", "Fanfic not found", "Author name is empty");
        } else if (repository.findByAuthor(name) == null){
            throw new BusinessException ("404", "Fanfic not found", "There isn't Fanfic with this Author in DB");
        }
        return fanficToDtoShort(repository.findByAuthor(name));
    }

    public List<FanficDto> getFanfics() {
        if (repository.findAll().isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "DB is empty");
        }
        return fanficsToDto(repository.findAll());
    }

    public List<FanficDtoShort> getFanficsShort() {
        if (repository.findAll().isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "DB is empty");
        }
        return fanficsToDtoShort(repository.findAll());
    }

    public List<FanficDto> getAllByAuthor(String name) {
        if (name.isEmpty()){
            throw new BusinessException ("400", "Fanfics not found", "Author name is empty");
        } else if (repository.findAllByAuthor(name).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Author in DB");
        }
        return fanficsToDto(repository.findAllByAuthor(name));
    }

    public List<FanficDtoShort> getAllByAuthorShort(String name) {
        if (name.isEmpty()){
            throw new BusinessException ("400", "Fanfics not found", "Author name is empty");
        } else if (repository.findAllByAuthor(name).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Author in DB");
        }
        return fanficsToDtoShort(repository.findAllByAuthor(name));
    }

    public List<FanficDto> getAllByGenre(String genre) {
        if (genre.isEmpty()){
            throw new BusinessException ("400", "Fanfics not found", "Genre name is empty");
        } else if (repository.findAllByGenre(genre).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Genre in DB");
        }
        return fanficsToDto(repository.findAllByGenre(genre));
    }

    public List<FanficDtoShort> getAllByGenreShort(String genre) {
        if (genre.isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "Genre name is empty");
        } else if (repository.findAllByGenre(genre).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Genre in DB");
        }
        return fanficsToDtoShort(repository.findAllByGenre(genre));
    }

    public List<FanficDto> getAllByFandom(String fandom) {
        if (fandom.isEmpty()){
            throw new BusinessException ("400", "Fanfics not found", "Fandom name is empty");
        } else if (repository.findAllByFandom(fandom).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Fandom in DB");
        }
        return fanficsToDto(repository.findAllByFandom(fandom));
    }

    public List<FanficDtoShort> getAllByFandomShort(String fandom) {
        if (fandom.isEmpty()){
            throw new BusinessException ("400", "Fanfics not found", "Fandom name is empty");
        } else if (repository.findAllByFandom(fandom).isEmpty()){
            throw new BusinessException ("404", "Fanfics not found", "There isn't Fanfics with this Fandom in DB");
        }
        return fanficsToDtoShort(repository.findAllByFandom(fandom));
    }

    public String deleteById(int id) {
        if (id < 0){
            throw new BusinessException ("400", "Fanfic not found", "ID is less than zero");
        } else if (repository.findById(id).orElse(null) == null){
            throw new BusinessException ("404", "Fanfic not found", "There isn't Fanfic with this ID in DB");
        }
        repository.deleteById(id);
        return "Fanfic ID: " + id + " deleted";
    }

    public FanficDto updateFanfic(FanficDto fanficDto) {
        if (fanficDto == null){
            throw new BusinessException ("400", "Fanfic not found", "Fanfic is empty");
        }
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

    private FanficDtoShort fanficToDtoShort(Fanfic fanfic) {return FanficShortMapper.INSTANCE.fanficDtoShort(fanfic);}

    private List<FanficDtoShort> fanficsToDtoShort(List<Fanfic> fanfics) {
        return FanficShortMapper.INSTANCE.fanficsToDtoShort(fanfics);
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