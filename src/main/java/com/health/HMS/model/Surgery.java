package com.health.HMS.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryNumber;

    private String postcode;

    @ManyToOne
    @JoinColumn(name = "council")
    private Region region;
}