package com.thesis.webspajz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantity;
    private String unit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
}
