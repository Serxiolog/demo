package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    private String title;
    private String description;
    private Integer author;

    @JsonCreator
    public Video(
            @JsonProperty(value = "title") String title,
            @JsonProperty(value = "description") String description,
            @JsonProperty(value = "author") Integer author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

}
