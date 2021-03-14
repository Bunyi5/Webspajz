package com.thesis.webspajz.service;

import com.thesis.webspajz.configuration.JwtTokenUtil;
import com.thesis.webspajz.dto.UserDTO;
import com.thesis.webspajz.model.jwt.JwtRequest;
import com.thesis.webspajz.model.jwt.JwtResponse;
import com.thesis.webspajz.model.jwt.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthenticationService {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;

    public JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch(BadCredentialsException e) {
            log.info("Incorrect username: " + authenticationRequest.getUsername() + " or password.");
            throw new BadCredentialsException("Incorrect username or password", e);
        }

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        log.info("Successful login with: " + authenticationRequest.getUsername() + " username.");

        return new JwtResponse(token);
    }

    public UserDTO getLoggedInUser() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        JwtUserDetails authPrinciple = validatePrinciple(authentication.getPrincipal());
        return new UserDTO(authPrinciple.getUser());
    }

    private JwtUserDetails validatePrinciple(Object principal) {
        if (principal instanceof JwtUserDetails) {
            return (JwtUserDetails) principal;
        } else {
            throw new  IllegalArgumentException("Principal type is not supported!");
        }
    }
}
