package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestDto {
    private String shortName;
    private String fullName;

    public TestDto() {
    }

    @JsonCreator
    public TestDto(
            @JsonProperty(value = "shortName") String shortName,
            @JsonProperty(value = "fullName") String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

}
