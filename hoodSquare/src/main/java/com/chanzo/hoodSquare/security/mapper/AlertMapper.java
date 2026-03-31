package com.chanzo.hoodSquare.security.mapper;

import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import com.chanzo.hoodSquare.security.model.Alert;

public class AlertMapper {
    public static AlertResponseDTO toDTO(Alert alert){
        AlertResponseDTO dto = new AlertResponseDTO();
        dto.setId(alert.getId());
        dto.setLocation(alert.getLocation());
        dto.setDescription(alert.getDescription());
        dto.setCreatedAt(alert.getCreatedAt());
        dto.setImage(alert.getImage());
        return dto;
    }
    public static Alert toEntity(AlertRequestDTO requestDTO){
        Alert alert= new Alert();
        alert.setLocation(requestDTO.getLocation());
        alert.setDescription(requestDTO.getDescription());
        return alert;
    }
}
