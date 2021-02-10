package com.thesis.webspajz.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserIngredientPK implements Serializable {

    private Long userId;
    private Long ingredientId;
}
