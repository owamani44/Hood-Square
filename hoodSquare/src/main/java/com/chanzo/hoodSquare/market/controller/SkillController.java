package com.chanzo.hoodSquare.market.controller;

import com.chanzo.hoodSquare.market.dtos.SkillRequestDTO;
import com.chanzo.hoodSquare.market.dtos.SkillResponseDTO;
import com.chanzo.hoodSquare.market.model.Skill;
import com.chanzo.hoodSquare.market.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin("http://localhost:5173")
@AllArgsConstructor
public class SkillController {
    private final SkillService service;
    @PostMapping
    public ResponseEntity<SkillResponseDTO> uploadSkill
            (@RequestBody SkillRequestDTO requestDTO){
        SkillResponseDTO dto = service.uploadSkill(requestDTO);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping
    public ResponseEntity<List<SkillResponseDTO>> getAll(){
       List<SkillResponseDTO> dto2 = service.getSkills();
        return ResponseEntity.ok().body(dto2);
    }
}
