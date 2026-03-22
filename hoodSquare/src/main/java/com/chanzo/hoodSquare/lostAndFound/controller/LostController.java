package com.chanzo.hoodSquare.lostAndFound.controller;

import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.service.LostService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/lost")
@AllArgsConstructor
public class LostController {
    private final LostService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LostResponseDTO> postLostItem
            (@ModelAttribute LostRequestDTO requestDTO,
             @RequestParam (value = "image", required = false ) MultipartFile image){
        LostResponseDTO dto = service.postLostItem(requestDTO,image);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<LostResponseDTO>> getAllLost(){
        List<LostResponseDTO> dto1 = service.getAllLost();
        return ResponseEntity.ok().body(dto1);
    }
}
