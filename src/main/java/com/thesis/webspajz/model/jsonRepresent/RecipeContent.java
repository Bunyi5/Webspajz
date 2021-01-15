package com.thesis.webspajz.model.jsonRepresent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesis.webspajz.model.jsonRepresent.description.Description;
import com.thesis.webspajz.model.jsonRepresent.details.Details;
import com.thesis.webspajz.model.jsonRepresent.ingredientLines.IngredientLines;
import com.thesis.webspajz.model.jsonRepresent.reviews.Reviews;
import com.thesis.webspajz.model.jsonRepresent.tags.Tags;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RecipeContent {

    private Description description = new Description();
    private Tags tags = new Tags();
    private List<String> preparationSteps = new ArrayList<>();
    private Details details = new Details();
    @JsonProperty("ingredientLines")
    private List<IngredientLines> ingredientLinesList = new ArrayList<>(List.of(new IngredientLines()));
    private Reviews reviews = new Reviews();

    public void setDescription(Description description) {
        if (description != null) {
            this.description = description;
        }
    }

    public void setTags(Tags tags) {
        if (tags != null) {
            this.tags = tags;
        }
    }

    public void setPreparationSteps(List<String> preparationSteps) {
        if (preparationSteps != null) {
            this.preparationSteps = preparationSteps;
        }
    }

    public void setDetails(Details details) {
        if (details != null) {
            this.details = details;
        }
    }

    public void setIngredientLinesList(List<IngredientLines> ingredientLinesList) {
        if (ingredientLinesList != null) {
            this.ingredientLinesList = ingredientLinesList;
        }
    }

    public void setReviews(Reviews reviews) {
        if (reviews != null) {
            this.reviews = reviews;
        }
    }
}
