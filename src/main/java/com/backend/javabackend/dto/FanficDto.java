package com.backend.javabackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FanficDto {

    private int id;
    private String name;
    private String author;
    private String fandom;
    private String genre;
    private String creationDateString;
    private double rating = 5;
    private int quantityRatings = 1;
    private double avgRating = rating / quantityRatings;
}
