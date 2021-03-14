package com.thesis.webspajz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIngredientResponseDTO {

    private Long ingredientId;
    private String ingredientName;
    private Double quantity;
    private String unit;
}
