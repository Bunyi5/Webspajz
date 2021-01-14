package com.thesis.webspajz.repository;

import com.thesis.webspajz.dto.PresentedRecipeDTO;
import com.thesis.webspajz.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT new com.thesis.webspajz.dto.PresentedRecipeDTO(r.id, r.name, r.iconImageUrl) FROM Recipe r")
    List<PresentedRecipeDTO> findAllPresentedRecipe();
}
