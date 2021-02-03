package com.thesis.webspajz.controller;

import com.thesis.webspajz.dto.PresentedRecipeDTO;
import com.thesis.webspajz.model.Recipe;
import com.thesis.webspajz.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<PresentedRecipeDTO>> allPresentedRecipe() {
        return ResponseEntity.ok(recipeService.getAllPresentedRecipe());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> showRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }

    @GetMapping("/tryAuth")
    public String firstPage() {
        return "success";
    }
}
