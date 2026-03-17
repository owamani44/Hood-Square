package com.chanzo.hoodSquare.market.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequestDTO {

    @NotBlank
    private String username;
    @NotBlank
    @Size(message = "Must include the skill/service name")
    private String skillName;
    @NotBlank
    @Size(message = "Must include description of the service and rate at which the service is offered")
    private String description;
    private Double amount;
}
