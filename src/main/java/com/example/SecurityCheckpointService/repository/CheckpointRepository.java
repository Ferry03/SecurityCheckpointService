package com.example.SecurityCheckpointService.repository;

import com.example.SecurityCheckpointService.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
}