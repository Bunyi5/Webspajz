package com.thesis.webspajz.model.jsonRepresent.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Technique {

    @JsonProperty("display-name")
    private String techniqueType;
}
