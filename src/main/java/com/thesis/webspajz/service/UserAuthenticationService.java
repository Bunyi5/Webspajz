package com.thesis.webspajz.service;

import com.thesis.webspajz.model.User;
import com.thesis.webspajz.model.jwt.JwtUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

    private JwtUserDetails validatePrinciple(Object principal) {
        if (principal instanceof JwtUserDetails) {
            return (JwtUserDetails) principal;
        } else {
            throw new  IllegalArgumentException("Principal type is not supported!");
        }
    }

    public User getLoggedInUser() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        JwtUserDetails authPrinciple = validatePrinciple(authentication.getPrincipal());
        return authPrinciple.getUser();
    }
}
