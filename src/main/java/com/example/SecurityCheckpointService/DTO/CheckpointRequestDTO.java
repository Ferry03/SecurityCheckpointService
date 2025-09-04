package com.example.SecurityCheckpointService.DTO;


import lombok.Data;

@Data
public class CheckpointRequestDTO {

    private String packageId;

    private Long locationId;
}
