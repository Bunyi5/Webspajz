package com.thesis.webspajz.repository;

import com.thesis.webspajz.dto.UserIngredientResponseDTO;
import com.thesis.webspajz.model.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredient, Long> {

    @Modifying
    @Transactional
    void deleteByUserIdAndIngredientId(Long userId, Long ingredientId);

    @Query("SELECT new com.thesis.webspajz.dto.UserIngredientResponseDTO(" +
            "i.id, i.name, ui.quantity, i.unit) " +
            "FROM Ingredient i LEFT JOIN UserIngredient ui ON ui.ingredientId = i.id " +
            "AND ui.userId = :userId ORDER BY i.name")
    List<UserIngredientResponseDTO> findAllUserIngredientDTOWithUserId(@Param("userId") Long userId);
}
