package com.example.emergencyResponse.exceptions.domain;

import com.example.emergencyResponse.exceptions.NotFoundException;

public class UserNotFound extends NotFoundException {
    public UserNotFound(String message) {
        super("User not found: " + message);
    }
    
}
