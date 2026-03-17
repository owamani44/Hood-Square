package com.chanzo.hoodSquare.lostAndFound.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "claimed")
public class Claimed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private  String username;
    @NotNull
    @Column(name="claim_number")
    private String claimNumber;

}
