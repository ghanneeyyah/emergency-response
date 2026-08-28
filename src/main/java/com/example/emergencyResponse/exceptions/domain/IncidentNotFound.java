package com.example.emergencyResponse.exceptions.domain;

import com.example.emergencyResponse.exceptions.NotFoundException;

public class IncidentNotFound extends NotFoundException {
    public IncidentNotFound(String message) {
        super("Incident not found: " + message);
    }
    
}
