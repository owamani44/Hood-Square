package com.chanzo.hoodSquare.market.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "skill_name")
    private String skillName;
    private String description;
    private Double amount;
}
