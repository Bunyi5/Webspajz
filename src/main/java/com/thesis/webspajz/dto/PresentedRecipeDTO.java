package com.thesis.webspajz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PresentedRecipeDTO {

    private Long id;
    private String name;
    private String iconImageUrl;
}
