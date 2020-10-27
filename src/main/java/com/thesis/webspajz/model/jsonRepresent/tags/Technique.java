package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Technique {

    @JsonProperty("display-name")
    private String techniqueType = "";

    public void setTechniqueType(String techniqueType) {
        if (techniqueType != null) {
            this.techniqueType = techniqueType;
        }
    }
}
