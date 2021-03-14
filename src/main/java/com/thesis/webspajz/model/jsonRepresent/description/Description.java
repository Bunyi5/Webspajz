package com.thesis.webspajz.model.jsonRepresent.description;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Description {

    @JsonProperty("text")
    private String descriptionText = null;

    public void setDescriptionText(String descriptionText) {
        if (descriptionText != null && !descriptionText.equals("")) {
            this.descriptionText = descriptionText;
        }
    }
}
