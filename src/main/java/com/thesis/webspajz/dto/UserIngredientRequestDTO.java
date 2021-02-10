package com.thesis.webspajz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIngredientRequestDTO {

    private Long ingredientId;
    private Double quantity;
}
