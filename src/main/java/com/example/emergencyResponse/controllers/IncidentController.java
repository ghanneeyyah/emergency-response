package com.example.emergencyResponse.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emergencyResponse.entity.Incident;
import com.example.emergencyResponse.services.IncidentService;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }


    @RequestMapping("/create")
    public Incident createIncident(@RequestBody Incident incident, @RequestParam String username) {
        return incidentService.createIncident(username, incident);
    }
}
