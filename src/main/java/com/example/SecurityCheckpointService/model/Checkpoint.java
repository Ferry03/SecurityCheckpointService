package com.example.SecurityCheckpointService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String packageId;
    private Long locationId;
    private LocalDateTime timestamp;
}