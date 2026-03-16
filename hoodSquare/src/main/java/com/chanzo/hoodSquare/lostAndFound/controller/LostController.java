package com.chanzo.hoodSquare.lostAndFound.controller;

import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.service.LostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lost")
@AllArgsConstructor
public class LostController {
    private final LostService service;

    public ResponseEntity<LostResponseDTO> postLostItem
            (@RequestBody LostRequestDTO requestDTO){
        LostResponseDTO dto = service.postLostItem(requestDTO);
        return ResponseEntity.ok().body(dto);
    }
}
