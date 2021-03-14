package com.thesis.webspajz.service;

import com.thesis.webspajz.exception.UserAlreadyExistException;
import com.thesis.webspajz.model.User;
import com.thesis.webspajz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public void saveUser(User user) throws UserAlreadyExistException {
        if (isUserExists(user)) {
            log.info("Registration failed, due to already registered username: " + user.getUsername());
            throw new UserAlreadyExistException("User already exists with " + user.getUsername() + " username!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("New user registered with username: " + user.getUsername());
    }

    private boolean isUserExists(User user) {
        return userRepository.existsByUsername(user.getUsername());
    }
}
