package com.example.emergencyResponse.services;

import org.springframework.stereotype.Service;

import com.example.emergencyResponse.Entity.Incident;
import com.example.emergencyResponse.repositories.IncidentRepo;
import com.example.emergencyResponse.repositories.UserRepo;

@Service
public class IncidentService {
    private final IncidentRepo incidentRepo;

    private final UserRepo userRepo;
    
    public IncidentService(UserRepo userRepo, IncidentRepo incidentRepo) {
        this.userRepo = userRepo;
        this.incidentRepo = incidentRepo;
    }

    public Incident createIncident(String username, Incident incident) {
        // Find the user by username
        var user = userRepo.findByUsername(username);
        if (user != null) {
            // Associate the incident with the user
            incident.setUser(user);
            return incidentRepo.save(incident);
        }
        return null; // or throw an exception if user not found
    }

    public Incident getIncidentById(String username,Long id) {
        // Find the user by username
        var user = userRepo.findByUsername(username);
        if (user != null) {
            // Retrieve the incident by ID and check if it belongs to the user
            var incident = incidentRepo.findById(id).orElse(null);
            if (incident != null && incident.getUser().getId().equals(user.getId())) {
                return incident;
            }
        }
        return null; // or throw an exception if not found or not authorized
    }
}
