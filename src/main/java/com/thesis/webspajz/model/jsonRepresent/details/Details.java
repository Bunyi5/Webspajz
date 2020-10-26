package com.thesis.webspajz.model.jsonRepresent.details;

import lombok.Data;

import java.util.List;

@Data
public class Details {

    private String totalTime;
    private List<Images> images;
    private String name;
    private String recipeId;
    private int numberOfServings;
}
