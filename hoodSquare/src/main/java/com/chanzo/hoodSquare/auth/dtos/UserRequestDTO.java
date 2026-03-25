package com.chanzo.hoodSquare.auth.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String fullName;
    private String username;
    private String phoneNumber;
    private String password;
}
