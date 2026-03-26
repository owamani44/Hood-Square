package com.chanzo.hoodSquare.auth.dtos;

import com.chanzo.hoodSquare.auth.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String username;
    private Role role;
    private String password;
}
