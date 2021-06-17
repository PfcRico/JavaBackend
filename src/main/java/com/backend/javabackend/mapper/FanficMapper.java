package com.backend.javabackend.mapper;

import com.backend.javabackend.dto.FanficDto;
import com.backend.javabackend.entity.Fanfic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FanficMapper {

    FanficMapper INSTANCE = Mappers.getMapper(FanficMapper.class );

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = "dd.MM.yyyy")
    FanficDto fanficDto(Fanfic fanfic);

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = "dd.MM.yyyy")
    List<FanficDto> fanficsToDto(List<Fanfic> fanfics);

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = "dd.MM.yyyy")
    Fanfic fanficDtoToFanfic(FanficDto dto);

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = "dd.MM.yyyy")
    List<Fanfic> fanficsDtoToFanfics(List<FanficDto> fanfics);
}
