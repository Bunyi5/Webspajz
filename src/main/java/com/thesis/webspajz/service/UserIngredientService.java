package com.thesis.webspajz.service;

import com.thesis.webspajz.dto.UserIngredientResponseDTO;
import com.thesis.webspajz.dto.UserIngredientRequestDTO;
import com.thesis.webspajz.model.UserIngredient;
import com.thesis.webspajz.repository.UserIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserIngredientService {

    private final UserIngredientRepository userIngredientRepository;
    private final UserAuthenticationService userAuthenticationService;

    public void modifyUserIngredients(List<UserIngredientRequestDTO> requestDTOS) {
        requestDTOS.forEach(userIngredientRequestDTO -> {
            if (userIngredientRequestDTO.getQuantity() != 0.0) {
                saveUserIngredient(userIngredientRequestDTO);
            } else {
                deleteUserIngredient(userIngredientRequestDTO);
            }
        });
    }

    public List<UserIngredientResponseDTO> getLoggedUserIngredients() {
        return userIngredientRepository.findAllUserIngredientDTOWithUserId(userAuthenticationService.getLoggedInUser().getId());
    }

    private void saveUserIngredient(UserIngredientRequestDTO requestDTO) {
        userIngredientRepository.save(
                new UserIngredient(
                        userAuthenticationService.getLoggedInUser().getId(),
                        requestDTO.getIngredientId(),
                        requestDTO.getQuantity()
                ));
    }

    private void deleteUserIngredient(UserIngredientRequestDTO requestDTO) {
        userIngredientRepository.deleteByUserIdAndIngredientId(
                userAuthenticationService.getLoggedInUser().getId(),
                requestDTO.getIngredientId()
        );
    }
}
