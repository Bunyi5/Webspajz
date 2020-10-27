package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Tags {

    @JsonProperty("difficulty")
    private List<Difficulty> difficultyList = new ArrayList<>(List.of(new Difficulty()));

    @JsonProperty("nutrition")
    private List<Nutrition> nutritionList = new ArrayList<>(List.of(new Nutrition()));

    @JsonProperty("technique")
    private List<Technique> techniqueList = new ArrayList<>(List.of(new Technique()));

    public void setDifficultyList(List<Difficulty> difficultyList) {
        if (difficultyList != null) {
            this.difficultyList = difficultyList;
        }
    }

    public void setNutritionList(List<Nutrition> nutritionList) {
        if (nutritionList != null) {
            this.nutritionList = nutritionList;
        }
    }

    public void setTechniqueList(List<Technique> techniqueList) {
        if (techniqueList != null) {
            this.techniqueList = techniqueList;
        }
    }
}
