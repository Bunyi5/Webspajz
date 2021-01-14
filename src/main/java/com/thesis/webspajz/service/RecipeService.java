package com.thesis.webspajz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.thesis.webspajz.dto.PresentedRecipeDTO;
import com.thesis.webspajz.model.Ingredient;
import com.thesis.webspajz.model.Recipe;
import com.thesis.webspajz.model.jsonRepresent.Feed;
import com.thesis.webspajz.model.jsonRepresent.RecipeContent;
import com.thesis.webspajz.model.jsonRepresent.RecipeJson;
import com.thesis.webspajz.model.jsonRepresent.ingredientLines.IngredientLines;
import com.thesis.webspajz.model.jsonRepresent.tags.Nutrition;
import com.thesis.webspajz.model.jsonRepresent.tags.Technique;
import com.thesis.webspajz.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<PresentedRecipeDTO> getAllPresentedRecipe() {
        return recipeRepository.findAllPresentedRecipe();
    }

    public List<Recipe> getRecipesFromFile() {
        String data = "";

        try {
            File myObj = new File("F:\\recipes.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return convertFeedToRecipe(processJsonStringToFeed(data));
    }

    public Feed processJsonStringToFeed(String jsonString) {
        Feed feed = new Feed();
        ObjectMapper objectMapper = new JsonMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            feed = objectMapper.readValue(jsonString, Feed.class);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: Can not process json string!");
        }

        return feed;
    }

    public List<Recipe> convertFeedToRecipe(Feed feed) {
        List<RecipeJson> recipeJsonList = feed.getFeed();
        List<Recipe> recipeList = new ArrayList<>();

        for (RecipeJson recipeJson : recipeJsonList) {
            Recipe recipe = new Recipe();

            RecipeContent recipeContent = recipeJson.getRecipeContent();

            setRecipeDetails(recipe, recipeContent);
            setRecipeDescription(recipe, recipeContent);
            setRecipeReviews(recipe, recipeContent);
            setRecipeTags(recipe, recipeContent);
            setRecipePreparationSteps(recipe, recipeContent);
            setRecipeIngredients(recipe, recipeContent);

            recipeList.add(recipe);
        }

        return recipeList;
    }

    public void setRecipeDetails(Recipe recipe, RecipeContent recipeContent) {
        recipe.setYumId(recipeContent.getDetails().getRecipeId());
        recipe.setName(recipeContent.getDetails().getName());
        recipe.setNumberOfServings(recipeContent.getDetails().getNumberOfServings());
        recipe.setIconImageUrl(recipeContent.getDetails().getImages().get(0).getHostedLargeUrl());
        recipe.setResizableImageUrl(recipeContent.getDetails().getImages().get(0).getResizableImageUrl());
    }

    public void setRecipeDescription(Recipe recipe, RecipeContent recipeContent) {
        recipe.setDescription(recipeContent.getDescription().getDescriptionText());
    }

    public void setRecipeReviews(Recipe recipe, RecipeContent recipeContent) {
        recipe.setTotalReviewCount(recipeContent.getReviews().getTotalReviewCount());
        recipe.setAverageRating(recipeContent.getReviews().getAverageRating());
    }

    public void setRecipeTags(Recipe recipe, RecipeContent recipeContent) {
        recipe.setDifficultyLevel(recipeContent.getTags().getDifficultyList().get(0).getDifficultyLevel());
        recipe.setNutritionList(recipeContent.getTags().getNutritionList().stream().map(Nutrition::getNutritionData).collect(Collectors.toList()));
        recipe.setTechniqueList(recipeContent.getTags().getTechniqueList().stream().map(Technique::getTechniqueType).collect(Collectors.toList()));
    }

    public void setRecipePreparationSteps(Recipe recipe, RecipeContent recipeContent) {
        recipe.setPreparationSteps(recipeContent.getPreparationSteps());
    }

    public void setRecipeIngredients(Recipe recipe, RecipeContent recipeContent) {
        List<IngredientLines> ingredientLinesList = recipeContent.getIngredientLinesList();

        for (IngredientLines ingredientLines : ingredientLinesList) {
            Ingredient ingredient = new Ingredient();

            ingredient.setIngredient(ingredientLines.getIngredient());
            ingredient.setQuantity(ingredientLines.getAmount().getMetric().getQuantity());
            ingredient.setUnit(ingredientLines.getAmount().getMetric().getUnit().getAbbreviation());

            recipe.addToIngredientList(ingredient);
        }
    }
}
