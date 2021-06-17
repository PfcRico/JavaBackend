package com.backend.javabackend.dto;

public class FanficDtoShort {

    private int id;
    private String name;
    private String author;
    private String fandom;
    private String picUrl;

    public FanficDtoShort(){}

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

        FanficDtoShort that = (FanficDtoShort) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!author.equals(that.author)) return false;
        if (!fandom.equals(that.fandom)) return false;
        return picUrl.equals(that.picUrl);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + fandom.hashCode();
        result = 31 * result + picUrl.hashCode();
        return result;
    }
}
