package com.example.SecurityCheckpointService.controller;



import com.example.SecurityCheckpointService.model.Checkpoint;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkpoints")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class CheckpointController {
    private final CheckpointService service;

    @PostMapping
    @Operation(summary = "Enregistrer un nouveau point de contrôle", description = "Crée un nouveau point de contrôle pour un colis à une localisation spécifique")
    @ApiResponse(responseCode = "200", description = "Point de contrôle enregistré avec succès")
    public ResponseEntity<Checkpoint> recordCheckpoint(@RequestParam String packageId, @RequestParam Long locationId) {
        return ResponseEntity.ok(service.recordCheckpoint(packageId, locationId));
    }

}