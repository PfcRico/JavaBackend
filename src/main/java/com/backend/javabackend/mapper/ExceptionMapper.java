package com.backend.javabackend.mapper;

import com.backend.javabackend.customexception.BusinessException;
import com.backend.javabackend.dto.ExceptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface ExceptionMapper {

    ExceptionMapper INSTANCE = Mappers.getMapper(ExceptionMapper.class );

    ExceptionDto exceptionDto(BusinessException businessException);
}
