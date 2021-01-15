package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Nutrition {

    @JsonProperty("display-name")
    private String nutritionData = null;

    public void setNutritionData(String nutritionData) {
        if (nutritionData != null && !nutritionData.equals("")) {
            this.nutritionData = nutritionData;
        }
    }
}
