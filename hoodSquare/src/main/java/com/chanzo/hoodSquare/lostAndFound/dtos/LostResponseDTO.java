package com.chanzo.hoodSquare.lostAndFound.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostResponseDTO {
    private Long id;
    private String message;
    private boolean claimed;
    private String claimNumber;
}
