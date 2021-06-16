package com.backend.javabackend.dto;

import lombok.Data;

@Data
public class FanficDtoShort {

    private int id;
    private String name;
    private String author;
    private String fandom;
    private String picUrl;
}
