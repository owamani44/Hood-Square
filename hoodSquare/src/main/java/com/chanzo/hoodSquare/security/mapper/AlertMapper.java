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
        dto.setImage(dto.getImage());
        return dto;
    }
    public static Alert toEntity(AlertRequestDTO requestDTO){
        Alert alert= new Alert();
        alert.setLocation(requestDTO.getLocation());
        alert.setDescription(requestDTO.getDescription());
        alert.setImage(requestDTO.getImage());
        return alert;
    }
}
