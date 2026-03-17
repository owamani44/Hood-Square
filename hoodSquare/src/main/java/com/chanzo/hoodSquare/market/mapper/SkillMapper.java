package com.chanzo.hoodSquare.market.mapper;

import com.chanzo.hoodSquare.market.dtos.SkillRequestDTO;
import com.chanzo.hoodSquare.market.dtos.SkillResponseDTO;
import com.chanzo.hoodSquare.market.model.Skill;

public class SkillMapper {
    public static SkillResponseDTO toDTO(Skill skill){
        SkillResponseDTO dto = new SkillResponseDTO();
        dto.setId(skill.getId());
        dto.setUsername(skill.getUsername());
        dto.setDescription(skill.getDescription());
        dto.setAmount(skill.getAmount());
        return dto;
    }
    public static Skill toEntity(SkillRequestDTO requestDTO){
        Skill skill = new Skill();
        skill.setUsername(requestDTO.getUsername());
        skill.setSkillName(requestDTO.getSkillName());
        skill.setDescription(requestDTO.getDescription());
        skill.setAmount(requestDTO.getAmount());
        return skill;
    }
}
