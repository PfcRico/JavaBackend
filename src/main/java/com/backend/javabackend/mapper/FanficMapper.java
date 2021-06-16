package com.backend.javabackend.mapper;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.entity.Fanfic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FanficMapper {

    FanficMapper INSTANCE = Mappers.getMapper(FanficMapper.class );

    FanficDto fanficDto(Fanfic fanfic);
    List<FanficDto> fanficsToDto(List<Fanfic> fanfics);
    Fanfic fanficDtoToFanfic(FanficDto dto);
    List<Fanfic> fanficsDtoToFanfics(List<FanficDto> fanfics);
}
