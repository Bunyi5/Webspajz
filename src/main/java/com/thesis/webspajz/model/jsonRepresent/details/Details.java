package com.thesis.webspajz.model.jsonRepresent.details;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Details {

    private String totalTime = null;
    private List<Images> images = new ArrayList<>(List.of(new Images()));
    private String name = null;
    private String recipeId = null;
    @Setter
    private int numberOfServings = 0;

    public void setTotalTime(String totalTime) {
        if (totalTime != null && !totalTime.equals("")) {
            this.totalTime = totalTime;
        }
    }

    public void setImages(List<Images> images) {
        if (images != null) {
            this.images = images;
        }
    }

    public void setName(String name) {
        if (name != null && !name.equals("")) {
            this.name = name;
        }
    }

    public void setRecipeId(String recipeId) {
        if (recipeId != null && !recipeId.equals("")) {
            this.recipeId = recipeId;
        }
    }
}
