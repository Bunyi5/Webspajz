package com.thesis.webspajz.model.jsonRepresent.details;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Details {

    private String totalTime = "";
    private List<Images> images = new ArrayList<>(List.of(new Images()));
    private String name = "";
    private String recipeId = "";
    @Setter
    private int numberOfServings = 0;

    public void setTotalTime(String totalTime) {
        if (totalTime != null) {
            this.totalTime = totalTime;
        }
    }

    public void setImages(List<Images> images) {
        if (images != null) {
            this.images = images;
        }
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setRecipeId(String recipeId) {
        if (recipeId != null) {
            this.recipeId = recipeId;
        }
    }
}
