package com.chanzo.hoodSquare.auth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotNull
    private String password;
}
