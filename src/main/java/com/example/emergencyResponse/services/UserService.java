package com.example.emergencyResponse.services;

import org.springframework.stereotype.Service;

import com.example.emergencyResponse.entity.User;
import com.example.emergencyResponse.exceptions.domain.UserNotFound;
import com.example.emergencyResponse.repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        String encodedPassword = new PasswordService().encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public Boolean authenticateUser(String username, String password) {
        User user = userRepo.findByUsername(username)
                    .orElseThrow(()-> new UserNotFound());
        
        return new PasswordService().matches(password, user.getPassword());
        
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(()-> new UserNotFound());
    }
}
