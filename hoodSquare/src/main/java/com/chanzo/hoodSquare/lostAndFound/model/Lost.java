package com.chanzo.hoodSquare.lostAndFound.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lost")
public class Lost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String message;

    private byte[] image;
    @NotNull
    private boolean claimed;
    @NotNull
    @Column(name = "claim_number")
    private String claimNumber;
}
