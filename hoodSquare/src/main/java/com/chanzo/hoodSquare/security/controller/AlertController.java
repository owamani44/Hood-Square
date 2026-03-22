package com.chanzo.hoodSquare.security.controller;

import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import com.chanzo.hoodSquare.security.service.AlertService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@AllArgsConstructor
@RequestMapping("/alerts")
public class AlertController {
    private final AlertService service;

    @PostMapping
    public ResponseEntity<AlertResponseDTO> reportAlert
            (@ModelAttribute AlertRequestDTO alertRequestDTO,
             @RequestParam(value = "image", required = false ) MultipartFile image){
        AlertResponseDTO newAlert = service.reportAlert(alertRequestDTO, image);
        return ResponseEntity.ok().body(newAlert);
    }
    @GetMapping
    public ResponseEntity<List<AlertResponseDTO>> getAllAlerts(){
        List<AlertResponseDTO> dto = service.getAllAlerts();
        return ResponseEntity.ok().body(dto);
    }
}
