package com.chanzo.hoodSquare.market.service;

import com.chanzo.hoodSquare.auth.service.UserInfoService;
import com.chanzo.hoodSquare.market.dtos.SkillRequestDTO;
import com.chanzo.hoodSquare.market.dtos.SkillResponseDTO;
import com.chanzo.hoodSquare.market.mapper.SkillMapper;
import com.chanzo.hoodSquare.market.model.Skill;
import com.chanzo.hoodSquare.market.repo.SkillRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillService {
    private final SkillRepo repo;
    private final UserInfoService userInfoService;

    public SkillResponseDTO uploadSkill(SkillRequestDTO requestDTO){
       if(userInfoService.isValidUser(requestDTO.getUsername())){
           throw new RuntimeException("Must be a valid user");
       }
        Skill skill= repo.save(SkillMapper.toEntity(requestDTO));
        return SkillMapper.toDTO(skill);
    }

    public List<SkillResponseDTO> getSkills(){
        List<Skill> skills = repo.findAll();
        return skills.stream().map(SkillMapper::toDTO).toList();
    }
}
