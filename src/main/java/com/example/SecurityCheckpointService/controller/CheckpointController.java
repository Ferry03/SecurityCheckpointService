package com.example.SecurityCheckpointService.controller;


import com.example.SecurityCheckpointService.DTO.CheckpointRequestDTO;
import com.example.SecurityCheckpointService.DTO.CheckpointResponseDTO;
import com.example.SecurityCheckpointService.service.CheckpointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkpoints")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class CheckpointController {

    private final CheckpointService service;

    @PostMapping
    @Operation(summary = "Enregistrer un nouveau point de controle", description = "Crée un nouveau point de controle pour un colis à une localisation specifique")
    @ApiResponse(responseCode = "200", description = "Point de contrôle enregistré avec succès")
    public ResponseEntity<CheckpointResponseDTO> recordCheckpoint(@RequestBody CheckpointRequestDTO request) {
        return ResponseEntity.ok(service.recordCheckpoint(request));
    }
}
