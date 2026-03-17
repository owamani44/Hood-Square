package com.chanzo.hoodSquare.auth.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String password;
}
