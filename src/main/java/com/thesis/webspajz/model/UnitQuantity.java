package com.thesis.webspajz.model;

import lombok.Data;

@Data
public class UnitQuantity {

    private final Long recipeId;
    private final Double recipeIngredientQuantity;
    private final String recipeIngredientUnit;
    private final Double userIngredientQuantity;
    private final String ingredientUnit;

    public boolean isQuantitiesEqualsOrUserIngredientQuantityBigger() {
        if (recipeIngredientQuantity == null) {
            return userIngredientQuantity == null;
        } else if (userIngredientQuantity == null) {
            return false;
        }
        return recipeIngredientQuantity <= userIngredientQuantity;
    }

    public boolean isUnitsEquals() {
        if (recipeIngredientUnit == null) {
            return ingredientUnit == null;
        }
        return recipeIngredientUnit.equals(ingredientUnit);
    }
}
