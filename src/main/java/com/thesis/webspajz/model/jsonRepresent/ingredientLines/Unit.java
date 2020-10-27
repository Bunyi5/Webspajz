package com.thesis.webspajz.model.jsonRepresent.ingredientLines;

import lombok.Getter;

@Getter
public class Unit {

    private String abbreviation = "";

    public void setAbbreviation(String abbreviation) {
        if (abbreviation != null) {
            this.abbreviation = abbreviation;
        }
    }
}
