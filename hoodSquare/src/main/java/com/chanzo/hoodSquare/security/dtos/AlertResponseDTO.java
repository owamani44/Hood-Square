package com.chanzo.hoodSquare.security.dtos;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AlertResponseDTO {
    private long id;
    private String location;
    private String description;
    private LocalDateTime createdAt;
    private byte[] image;

}
