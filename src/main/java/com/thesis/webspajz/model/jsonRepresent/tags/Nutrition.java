package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Nutrition {

    @JsonProperty("display-name")
    private String nutritionData;
}
