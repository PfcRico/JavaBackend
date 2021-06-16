package com.backend.javabackend.mapper;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.dto.FanficDtoShort;
import com.backend.javabackend.entity.Fanfic;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface FanficShortMapper {

    FanficShortMapper INSTANCE = Mappers.getMapper(FanficShortMapper.class );

    FanficDtoShort fanficDtoShort(Fanfic fanfic);
    List<FanficDtoShort> fanficsToDtoShort(List<Fanfic> fanfics);
    Fanfic fanficDtoShortToFanfic(FanficDtoShort dto);
    List<Fanfic> fanficsDtoShortToFanfics(List<FanficDtoShort> fanfics);
}
