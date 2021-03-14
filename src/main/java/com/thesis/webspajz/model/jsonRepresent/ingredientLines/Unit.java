package com.thesis.webspajz.model.jsonRepresent.ingredientLines;

import lombok.Getter;

@Getter
public class Unit {

    private String abbreviation = null;

    public void setAbbreviation(String abbreviation) {
        if (abbreviation != null && !abbreviation.equals("")) {
            this.abbreviation = abbreviation;
        }
    }
}
