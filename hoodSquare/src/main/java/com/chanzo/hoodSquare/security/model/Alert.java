package com.chanzo.hoodSquare.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;
    private String description;
    private byte[] image;
}
