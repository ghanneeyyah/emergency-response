package com.example.emergencyResponse.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.example.emergencyResponse.Entity.enums.Status;
import com.example.emergencyResponse.Entity.enums.Type;

@Entity
@Table(name = "incidents")
@Getter
@Setter
public class Incident {
    private Long id;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Enum<Status> Status;
    private Enum<Type> Type;

}
