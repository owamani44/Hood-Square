package com.chanzo.hoodSquare.security.service;

import com.chanzo.hoodSquare.event.AlertReportedEvent;
import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import com.chanzo.hoodSquare.security.mapper.AlertMapper;
import com.chanzo.hoodSquare.security.model.Alert;
import com.chanzo.hoodSquare.security.mapper.repo.AlertRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class AlertService {
    private final AlertRepo repo;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public AlertResponseDTO reportAlert(AlertRequestDTO requestDTO){
        Alert newAlert = repo.save(AlertMapper.toEntity(requestDTO));
        publisher.publishEvent(new AlertReportedEvent(newAlert.getLocation()
                ,newAlert.getDescription(),newAlert.getImage()));
        return AlertMapper.toDTO(newAlert);
    }
}
