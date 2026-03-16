package com.chanzo.hoodSquare.lostAndFound.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostRequestDTO {
    private String message;
    private byte[] image;
    private boolean claimed;
}
