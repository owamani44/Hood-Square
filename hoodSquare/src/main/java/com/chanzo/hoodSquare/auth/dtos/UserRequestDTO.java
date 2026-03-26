package com.chanzo.hoodSquare.auth.dtos;

import com.chanzo.hoodSquare.auth.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String fullName;
    private String username;
    private String phoneNumber;
    private Role role;
    private String password;
}
