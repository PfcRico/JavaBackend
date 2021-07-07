package com.backend.javabackend.service;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.entity.Fanfic;
import com.backend.javabackend.mapper.FanficMapper;
import com.backend.javabackend.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SearchService {

    @Autowired
    private SearchRepo repo;

    public List<FanficDto> findWordInText(String text){
        return fanficsToDto(repo.searchInTextWord(text));
    }

    private List<FanficDto> fanficsToDto(List<Fanfic> fanfics) {
        return FanficMapper.INSTANCE.fanficsToDto(fanfics);
    }
}
