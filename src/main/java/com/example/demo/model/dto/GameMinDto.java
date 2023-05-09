package com.example.demo.model.dto;

import com.example.demo.model.Game;

public class GameMinDto {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String imgUrl;
    private String shortDescription;
    public GameMinDto() {
    }
    public GameMinDto(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        genre = game.getGenre();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Integer getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    
}
