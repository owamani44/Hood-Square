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
    @Column(name="first_name")
    private String firstName;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private String tel;
    @NotNull
    private String password;
}
