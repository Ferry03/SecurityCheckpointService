package com.example.SecurityCheckpointService.DTO;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckpointResponseDTO {
    private Long id;
    private String packageId;
    private Long locationId;
    private LocalDateTime timestamp;
}