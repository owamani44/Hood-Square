package com.chanzo.hoodSquare.security.service;

import com.chanzo.hoodSquare.event.AlertReportedEvent;
import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import com.chanzo.hoodSquare.security.mapper.AlertMapper;
import com.chanzo.hoodSquare.security.model.Alert;
import com.chanzo.hoodSquare.security.repo.AlertRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@AllArgsConstructor
public class AlertService implements AlertServiceInterface {
    private final AlertRepo repo;
    private final ApplicationEventPublisher publisher;

    @Transactional
    @Override
    public AlertResponseDTO reportAlert(AlertRequestDTO requestDTO, MultipartFile image){
        try {
            Alert newAlert = repo.save(AlertMapper.toEntity(requestDTO));
            if (image!=null && !image.isEmpty()){
                newAlert.setImage(image.getBytes());
            }

            publisher.publishEvent(new AlertReportedEvent(newAlert.getLocation()
                    ,newAlert.getDescription(),newAlert.getImage()));
            return AlertMapper.toDTO(newAlert);
        }catch (Exception e){
            throw new RuntimeException("Error processing image  ", e);
        }
    }

    public List<AlertResponseDTO> getAllAlerts(){
        List<Alert> alerts = repo.findAll();
        return alerts.stream().map(AlertMapper::toDTO).toList();
    }
}
