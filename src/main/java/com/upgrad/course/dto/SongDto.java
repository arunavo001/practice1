package com.upgrad.course.dto;

import com.upgrad.course.entity.SongEntity;

public class SongDto {

    private String name;
    private String movieName;
    private String singer;

    public SongDto() {
    }

    public SongDto(String name, String movieName, String singer) {
        this.name = name;
        this.movieName = movieName;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public SongEntity convertToEntity() {
        return new SongEntity(name, movieName, singer);
    }
}
