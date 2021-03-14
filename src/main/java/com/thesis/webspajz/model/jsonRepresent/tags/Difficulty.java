package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Difficulty {

    @JsonProperty("display-name")
    private String difficultyLevel = null;

    public void setDifficultyLevel(String difficultyLevel) {
        if (difficultyLevel != null && !difficultyLevel.equals("")) {
            this.difficultyLevel = difficultyLevel;
        }
    }
}
