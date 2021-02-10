package com.thesis.webspajz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserIngredientPK.class)
public class UserIngredient {

    @Id
    private Long userId;
    @Id
    private Long ingredientId;
    private double quantity;
}
