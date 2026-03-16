package com.chanzo.hoodSquare.lostAndFound.controller;

import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import com.chanzo.hoodSquare.lostAndFound.service.LostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claim")
@AllArgsConstructor
public class ClaimController {
    private final LostService service;

    @PostMapping
    public ResponseEntity<Claimed> claimItem(@RequestBody ClaimRequestDTO requestDTO) {
        Claimed claimed = service.claimItem(requestDTO);
        return ResponseEntity.ok().body(claimed);
    }
}
