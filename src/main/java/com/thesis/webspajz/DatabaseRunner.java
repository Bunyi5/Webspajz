package com.thesis.webspajz;

import com.thesis.webspajz.model.Recipe;
import com.thesis.webspajz.repository.RecipeRepository;
import com.thesis.webspajz.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseRunner implements CommandLineRunner {

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    @Override
    public void run(String... args) {
        List<Recipe> recipes = recipeService.getRecipesFromTheInternet();
        recipeRepository.saveAll(recipes);
        log.info("All recipes saved into the database.");
    }
}
