package com.example.SecurityCheckpointService.service;


import com.example.SecurityCheckpointService.client.LocationClient;
import com.example.SecurityCheckpointService.model.Checkpoint;
import com.example.SecurityCheckpointService.repository.CheckpointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckpointService {
    private final CheckpointRepository repository;
    private final LocationClient locationClient;

    public Checkpoint recordCheckpoint(String packageId, Long locationId) {
        locationClient.getLocationById(locationId);
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setPackageId(packageId);
        checkpoint.setLocationId(locationId);
        checkpoint.setTimestamp(LocalDateTime.now());
        return repository.save(checkpoint);
    }

    public List<Checkpoint> getAllCheckpoints() {
        return repository.findAll();
    }

    public Checkpoint getCheckpointById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point de contrôle non trouvé"));
    }
}