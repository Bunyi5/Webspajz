package com.thesis.webspajz.service;

import com.thesis.webspajz.dto.PresentedRecipeDTO;
import com.thesis.webspajz.model.Completeness;

import java.util.Comparator;

public class PresentedRecipeComparator implements Comparator<PresentedRecipeDTO> {

    @Override
    public int compare(PresentedRecipeDTO o1, PresentedRecipeDTO o2) {
        Completeness comp1 = o1.getCompleteness();
        Completeness comp2 = o2.getCompleteness();

        if (comp1 == Completeness.GREEN && (comp2 == Completeness.YELLOW || comp2 == Completeness.RED) ||
            comp1 == Completeness.YELLOW && comp2 == Completeness.RED) {
            return -1;
        } else if (comp1 == comp2) {
            return 0;
        } else {
            return 1;
        }
    }
}
