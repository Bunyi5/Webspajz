package com.thesis.webspajz.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String yumId;
    private String name;
    private String description;
    private int numberOfServings;
    private String iconImageUrl;
    private String resizableImageUrl;
    private long totalReviewCount;
    private double averageRating;
    private String difficultyLevel;

    @ElementCollection
    private List<String> nutritionList;
    @ElementCollection
    private List<String> techniqueList;
    @ElementCollection
    private List<String> preparationSteps;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

    public void addToIngredientList(RecipeIngredient recipeIngredient) {
        recipeIngredient.setRecipe(this);
        this.recipeIngredientList.add(recipeIngredient);
    }
}
