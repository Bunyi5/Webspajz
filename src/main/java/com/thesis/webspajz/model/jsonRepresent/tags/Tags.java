package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Tags {

    @JsonProperty("difficulty")
    private List<Difficulty> difficultyList;

    @JsonProperty("nutrition")
    private List<Nutrition> nutritionList;

    @JsonProperty("technique")
    private List<Technique> techniqueList;
}
