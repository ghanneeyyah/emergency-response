package com.example.emergencyResponse.services;

import org.springframework.stereotype.Service;

import com.example.emergencyResponse.entity.Incident;
import com.example.emergencyResponse.entity.User;
import com.example.emergencyResponse.exceptions.domain.UserNotFound;
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
        User user = userRepo.findByUsername(username)
                .orElseThrow(()-> new UserNotFound());
        
        incident.setUser(user);
        return incidentRepo.save(incident); 
    }

    public Incident getIncidentById(String username,Long id) {
        // Find the user by username
        User user = userRepo.findByUsername(username)
                    .orElseThrow(()-> new UserNotFound());
        
        // Retrieve the incident by ID
        Incident incident = incidentRepo.findById(id).orElse(null);
        
        if (incident != null && incident.getUser().getId().equals(user.getId())) {
            return incident;
        }
        
        return null; 
    }
}
