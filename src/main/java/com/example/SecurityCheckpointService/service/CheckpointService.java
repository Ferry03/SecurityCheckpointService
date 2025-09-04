package com.example.SecurityCheckpointService.service;

import com.example.SecurityCheckpointService.client.LocationClient;
import com.example.SecurityCheckpointService.mapper.CheckpointMapper;
import com.example.SecurityCheckpointService.model.Checkpoint;
import com.example.SecurityCheckpointService.DTO.CheckpointRequestDTO;
import com.example.SecurityCheckpointService.DTO.CheckpointResponseDTO;
import com.example.SecurityCheckpointService.repository.CheckpointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckpointService {
    private final CheckpointRepository repository;
    private final LocationClient locationClient;
    private final CheckpointMapper mapper;

    public CheckpointResponseDTO recordCheckpoint(CheckpointRequestDTO request) {
        locationClient.getLocationById(request.getLocationId());
        Checkpoint checkpoint = mapper.toEntity(request);
        checkpoint.setTimestamp(LocalDateTime.now());
        return mapper.toDto(repository.save(checkpoint));
    }

    public List<CheckpointResponseDTO> getAllCheckpoints() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CheckpointResponseDTO getCheckpointById(Long id) {
        Checkpoint checkpoint = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point de contrôle non trouvé"));
        return mapper.toDto(checkpoint);
    }
}