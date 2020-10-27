package com.thesis.webspajz.model.jsonRepresent.ingredientLines;

import lombok.Getter;

@Getter
public class Amount {

    private Metric metric = new Metric();

    public void setMetric(Metric metric) {
        if (metric != null) {
            this.metric = metric;
        }
    }
}
