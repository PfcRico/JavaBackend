package com.backend.javabackend.controller;

import com.backend.javabackend.customexception.BusinessException;
import com.backend.javabackend.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<List<ExceptionDto>> handleNotFoundException(BusinessException e){
        final List<ExceptionDto> errorDto = new ArrayList<>();
        errorDto.add(new ExceptionDto(e.getErrorCode(), e.getErrorMessage(), e.getField()));
        return new ResponseEntity<>(errorDto,
                (e.getErrorCode().equals("400") ? HttpStatus.BAD_REQUEST : HttpStatus.NOT_FOUND));
    }
}
