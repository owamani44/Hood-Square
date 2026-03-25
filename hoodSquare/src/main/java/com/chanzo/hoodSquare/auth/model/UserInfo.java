package com.chanzo.hoodSquare.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo {
    @Id
    private Long id;
    @NotNull
    @Column(name="full_name")
    private String fullName;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(name = "phone_number", unique=true)
    private String phoneNumber;
    @NotNull
    private String role;
    @NotNull
    private String password;
}
