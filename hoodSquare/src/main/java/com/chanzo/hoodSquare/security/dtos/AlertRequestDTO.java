package com.chanzo.hoodSquare.security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertRequestDTO {
    private String location;
    private String description;
    private byte[] image;
}
