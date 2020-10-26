package com.thesis.webspajz.model.jsonRepresent.description;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Description {

    @JsonProperty("text")
    private String descriptionText;
}
