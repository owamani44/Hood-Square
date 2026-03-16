package com.chanzo.hoodSquare.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AlertResponseDTO {
    private long id;
    private String location;
    private String description;
    private byte[] image;

}
