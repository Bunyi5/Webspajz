package com.thesis.webspajz.model.jsonRepresent.ingredientLines;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Metric {

    private Unit unit = new Unit();
    @Setter
    private double quantity = 0.0;

    public void setUnit(Unit unit) {
        if (unit != null) {
            this.unit = unit;
        }
    }
}
