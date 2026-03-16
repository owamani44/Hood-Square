package com.chanzo.hoodSquare.security.controller;

import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import com.chanzo.hoodSquare.security.service.AlertService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/alerts")
public class AlertController {
    private final AlertService service;

    @PostMapping
    public ResponseEntity<AlertResponseDTO> reportAlert(@RequestBody AlertRequestDTO alertRequestDTO){
        AlertResponseDTO newAlert = service.reportAlert(alertRequestDTO);
        return ResponseEntity.ok().body(newAlert);
    }
}
