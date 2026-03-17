package com.chanzo.hoodSquare.lostAndFound.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimResponseDTO {
    private Long id;
    private String username;
    private String claimNumber;
}
