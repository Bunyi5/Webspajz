package com.thesis.webspajz.controller;

import com.thesis.webspajz.model.User;
import com.thesis.webspajz.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserAuthenticationService userAuthenticationService;

    @GetMapping("/user")
    public ResponseEntity<User> getLoggedUser() {
        return ResponseEntity.ok(userAuthenticationService.getLoggedInUser());
    }
}
