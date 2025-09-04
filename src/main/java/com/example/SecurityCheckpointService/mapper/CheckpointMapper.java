package com.example.SecurityCheckpointService.mapper;

import com.example.SecurityCheckpointService.model.Checkpoint;
import com.example.SecurityCheckpointService.DTO.CheckpointRequestDTO;
import com.example.SecurityCheckpointService.DTO.CheckpointResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CheckpointMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    Checkpoint toEntity(CheckpointRequestDTO dto);

    CheckpointResponseDTO toDto(Checkpoint entity);
}