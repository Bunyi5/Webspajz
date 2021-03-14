package com.thesis.webspajz.controller;

import com.thesis.webspajz.model.jwt.JwtRequest;
import com.thesis.webspajz.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        return ResponseEntity.ok(userAuthenticationService.createAuthenticationToken(authenticationRequest));
    }

    @GetMapping("/tryAuth")
    public ResponseEntity<Void> firstPage() {
        return ResponseEntity.ok().build();
    }
}
