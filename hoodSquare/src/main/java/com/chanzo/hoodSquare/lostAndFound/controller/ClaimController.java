package com.chanzo.hoodSquare.lostAndFound.controller;

import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import com.chanzo.hoodSquare.lostAndFound.service.LostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/claim")
@AllArgsConstructor
public class ClaimController {
    private final LostService service;

    @PostMapping
    public ResponseEntity<ClaimResponseDTO> claimItem(@RequestBody ClaimRequestDTO requestDTO) {
        ClaimResponseDTO claimDTO= service.claimItem(requestDTO);
        return ResponseEntity.ok().body(claimDTO);
    }
}
