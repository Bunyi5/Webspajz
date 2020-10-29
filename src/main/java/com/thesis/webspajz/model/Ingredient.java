package com.thesis.webspajz.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ingredient;
    private double quantity;
    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
}