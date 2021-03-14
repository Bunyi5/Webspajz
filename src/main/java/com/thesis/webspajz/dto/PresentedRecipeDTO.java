package com.thesis.webspajz.dto;

import com.thesis.webspajz.model.Completeness;
import lombok.Data;

@Data
public class PresentedRecipeDTO {

    private final Long id;
    private final String name;
    private final String iconImageUrl;
    private Completeness completeness;
}