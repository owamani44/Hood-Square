package com.chanzo.hoodSquare.market.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillResponseDTO {
    private Long id;
    private String username;
    private String skillName;
    private String description;
    private Double amount;
}
