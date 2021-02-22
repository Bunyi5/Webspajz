package com.thesis.webspajz.controller;

import com.thesis.webspajz.dto.UserDTO;
import com.thesis.webspajz.exception.UserAlreadyExistException;
import com.thesis.webspajz.model.User;
import com.thesis.webspajz.service.UserAuthenticationService;
import com.thesis.webspajz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserAuthenticationService userAuthenticationService;

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getLoggedUser() {
        return ResponseEntity.ok(userAuthenticationService.getLoggedInUser());
    }

    @PostMapping("/saveNewUser")
    public ResponseEntity<?> saveNewUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(409).build();
        }
    }
}
