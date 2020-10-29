package com.thesis.webspajz;

import com.thesis.webspajz.model.Recipe;
import com.thesis.webspajz.repository.RecipeRepository;
import com.thesis.webspajz.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseRunner implements CommandLineRunner {

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    @Override
    public void run(String... args) {
        List<Recipe> recipes = recipeService.getRecipesFromFile();
        recipeRepository.saveAll(recipes);
    }
}
