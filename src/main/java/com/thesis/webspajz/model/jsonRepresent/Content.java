package com.thesis.webspajz.model.jsonRepresent;

import com.thesis.webspajz.model.jsonRepresent.description.Description;
import com.thesis.webspajz.model.jsonRepresent.details.Details;
import com.thesis.webspajz.model.jsonRepresent.ingredientLines.IngredientLines;
import com.thesis.webspajz.model.jsonRepresent.reviews.Reviews;
import com.thesis.webspajz.model.jsonRepresent.tags.Tags;
import lombok.Data;

import java.util.List;

@Data
public class Content {

    private Description description;
    private Tags tags;
    private List<String> preparationSteps;
    private Details details;
    private List<IngredientLines> ingredientLines;
    private Reviews reviews;
}
