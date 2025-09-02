package com.example.SecurityCheckpointService.controller;



import com.example.SecurityCheckpointService.model.Checkpoint;
import com.example.SecurityCheckpointService.service.CheckpointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @Operation(summary = "Obtenir tous les points de contrôle", description = "Récupère la liste de tous les points de contrôle")
    @ApiResponse(responseCode = "200", description = "Liste des points de contrôle récupérée avec succès")
    public ResponseEntity<List<Checkpoint>> getAllCheckpoints() {
        return ResponseEntity.ok(service.getAllCheckpoints());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un point de contrôle par ID", description = "Récupère un point de contrôle spécifique par son ID")
    @ApiResponse(responseCode = "200", description = "Point de contrôle récupéré avec succès")
    @ApiResponse(responseCode = "404", description = "Point de contrôle non trouvé")
    public ResponseEntity<Checkpoint> getCheckpointById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCheckpointById(id));
    }
}