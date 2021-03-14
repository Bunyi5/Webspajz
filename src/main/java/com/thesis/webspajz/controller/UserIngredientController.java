package com.thesis.webspajz.controller;

import com.thesis.webspajz.dto.UserIngredientResponseDTO;
import com.thesis.webspajz.dto.UserIngredientRequestDTO;
import com.thesis.webspajz.service.UserAuthenticationService;
import com.thesis.webspajz.service.UserIngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserIngredientController {

    private final UserIngredientService userIngredientService;
    private final UserAuthenticationService userAuthenticationService;

    @GetMapping("/ingredients")
    public ResponseEntity<List<UserIngredientResponseDTO>> getIngredients() {
        return ResponseEntity.ok(userIngredientService.getLoggedUserIngredients());
    }

    @PostMapping("/modifyQuantities")
    public ResponseEntity<Void> modifyUserIngredientQuantities(@RequestBody List<UserIngredientRequestDTO> requestDTOS) {
        try {
            userIngredientService.modifyUserIngredients(requestDTOS);
            log.info("User: " + userAuthenticationService.getLoggedInUser().getUsername() + " modified quantities.");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.info("Error saving quantities for user: " + userAuthenticationService.getLoggedInUser().getUsername());
            return ResponseEntity.status(404).build();
        }
    }
}
