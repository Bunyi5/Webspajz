package com.thesis.webspajz.model.jsonRepresent.ingredientLines;

import lombok.Getter;

@Getter
public class IngredientLines {

    private Amount amount = new Amount();
    private String ingredient = null;

    public void setAmount(Amount amount) {
        if (amount != null) {
            this.amount = amount;
        }
    }

    public void setIngredient(String ingredient) {
        if (ingredient != null && !ingredient.equals("")) {
            this.ingredient = ingredient;
        }
    }
}
