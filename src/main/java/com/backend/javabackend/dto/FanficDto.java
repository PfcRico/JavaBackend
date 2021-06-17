package com.backend.javabackend.dto;

public class FanficDto {

    private int id;
    private String name;
    private String author;
    private String fandom;
    private String genre;
    private String picUrl;
    private String creationDate;
    private double rating = 5;
    private int quantityRatings = 1;
    private double avgRating = rating / quantityRatings;

    public FanficDto(){}

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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FanficDto fanficDto = (FanficDto) o;

        if (id != fanficDto.id) return false;
        if (Double.compare(fanficDto.rating, rating) != 0) return false;
        if (quantityRatings != fanficDto.quantityRatings) return false;
        if (Double.compare(fanficDto.avgRating, avgRating) != 0) return false;
        if (!name.equals(fanficDto.name)) return false;
        if (!author.equals(fanficDto.author)) return false;
        if (!fandom.equals(fanficDto.fandom)) return false;
        if (!genre.equals(fanficDto.genre)) return false;
        return creationDate.equals(fanficDto.creationDate);
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
        result = 31 * result + creationDate.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantityRatings;
        temp = Double.doubleToLongBits(avgRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
