package com.example.emergencyResponse.exceptions;


public class GlobalException extends AppException {
    public GlobalException(String message) {
        super(message, 500);
    }
}
