package com.thesis.webspajz.service;

import com.thesis.webspajz.dto.PresentedRecipeDTO;
import com.thesis.webspajz.model.Completeness;
import com.thesis.webspajz.model.UnitQuantity;
import com.thesis.webspajz.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompletenessCalculator {

    private final IngredientRepository ingredientRepository;
    private final UserAuthenticationService userAuthenticationService;

    public List<PresentedRecipeDTO> fillCalculationInPresentedRecipeDTO(List<PresentedRecipeDTO> presentedRecipeDTOList) {
        List<UnitQuantity> unitQuantityList = ingredientRepository.findAllUnitQuantityWithUserId(
                userAuthenticationService.getLoggedInUser().getId()
        );

        presentedRecipeDTOList.forEach(recipeDTO ->
                recipeDTO.setCompleteness(calculateCompleteness(recipeDTO.getId(), unitQuantityList))
        );

        return presentedRecipeDTOList;
    }

    private Completeness calculateCompleteness(Long recipeId, List<UnitQuantity> unitQuantityList) {
        List<UnitQuantity> recipeUnitQuantityList = unitQuantityList.stream()
                .filter(unitQuantity -> unitQuantity.getRecipeId().equals(recipeId)).collect(Collectors.toList());

        int unitQuantitySum = recipeUnitQuantityList.size();
        AtomicInteger unitQuantityCounter = new AtomicInteger();

        recipeUnitQuantityList.forEach(unitQuantity -> {
            if (unitQuantity.isUnitsEquals()) {
                if (unitQuantity.isQuantitiesEqualsOrUserIngredientQuantityBigger())
                    unitQuantityCounter.getAndIncrement();
            } else {
                if (unitQuantity.getUserIngredientQuantity() != null)
                    unitQuantityCounter.getAndIncrement();
            }
        });

        return getCompletenessBasedOnSumAndCounter(unitQuantitySum, unitQuantityCounter.get());
    }

    private Completeness getCompletenessBasedOnSumAndCounter(int sum, int counter) {
        if (sum == counter) {
            return Completeness.GREEN;
        } else if ((int) Math.ceil((double) sum / 2) <= counter) {
            return Completeness.YELLOW;
        } else {
            return Completeness.RED;
        }
    }
}
