package com.thesis.webspajz.model.jsonRepresent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeJson {

    @JsonProperty("content")
    private RecipeContent recipeContent;
}
