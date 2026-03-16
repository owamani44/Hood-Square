package com.chanzo.hoodSquare.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInfo {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String tel;
    private String password;
}
