package com.thesis.webspajz.repository;

import com.thesis.webspajz.model.Ingredient;
import com.thesis.webspajz.model.UnitQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findByName(String ingredient);

    @Query("SELECT new com.thesis.webspajz.model.UnitQuantity( " +
            "r.recipe.id, r.quantity, r.unit, u.quantity, i.unit) " +
            "FROM RecipeIngredient r " +
            "JOIN Ingredient i ON i.id = r.ingredient.id " +
            "LEFT JOIN UserIngredient u ON u.ingredientId = i.id AND u.userId = :userId")
    List<UnitQuantity> findAllUnitQuantityWithUserId(@Param("userId") Long userId);
}
