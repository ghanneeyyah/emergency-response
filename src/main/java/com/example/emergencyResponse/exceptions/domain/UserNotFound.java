package com.example.emergencyResponse.exceptions.domain;

import com.example.emergencyResponse.exceptions.NotFoundException;

public class UserNotFound extends NotFoundException {
    public UserNotFound() {
        super("User not found: ");
    }
    
}
