package com.example.emergencyResponse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emergencyResponse.Entity.Incident;


@Repository
public interface IncidentRepo extends JpaRepository<Incident, Long> {
    // Custom query methods can be defined here if needed
    
}
