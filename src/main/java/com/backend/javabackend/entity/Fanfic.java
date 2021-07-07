package com.backend.javabackend.entity;

import org.hibernate.search.annotations.Field;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "FANFIC_TBL")
@Indexed
public class Fanfic {

    @Id
    @GeneratedValue
    private int id;

    @Field
    private String name;

    @Field
    private String author;
    private String fandom;
    private String genre;

    @Column(columnDefinition = "TEXT")
    @Field
    private String text;
    private Date creationDate = new Date();
    private String picUrl;
    private double rating = 5;
    private int quantityRatings = 1;
    private double avgRating = rating / quantityRatings;


    public Fanfic(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFandom() {
        return fandom;
    }

    public void setFandom(String fandom) {
        this.fandom = fandom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getQuantityRatings() {
        return quantityRatings;
    }

    public void setQuantityRatings(int quantityRatings) {
        this.quantityRatings = quantityRatings;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fanfic fanfic = (Fanfic) o;

        if (id != fanfic.id) return false;
        if (Double.compare(fanfic.rating, rating) != 0) return false;
        if (quantityRatings != fanfic.quantityRatings) return false;
        if (Double.compare(fanfic.avgRating, avgRating) != 0) return false;
        if (!name.equals(fanfic.name)) return false;
        if (!author.equals(fanfic.author)) return false;
        if (!fandom.equals(fanfic.fandom)) return false;
        if (!genre.equals(fanfic.genre)) return false;
        if (!text.equals(fanfic.text)) return false;
        if (!creationDate.equals(fanfic.creationDate)) return false;
        return picUrl.equals(fanfic.picUrl);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + fandom.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + picUrl.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantityRatings;
        temp = Double.doubleToLongBits(avgRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
