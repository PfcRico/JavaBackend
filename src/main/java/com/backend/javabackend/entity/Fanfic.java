package com.backend.javabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FANFIC_TBL")
public class Fanfic {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private String fandom;
    private String genre;
    private Date creationDate = new Date();
    private String picUrl;
    private double rating = 5;
    private int quantityRatings = 1;
    private double avgRating = rating / quantityRatings;

    public Fanfic(String name, String author, String fandom, String genre){
        this.name = name;
        this.author = author;
        this.fandom = fandom;
        this.genre = genre;
    }

}
