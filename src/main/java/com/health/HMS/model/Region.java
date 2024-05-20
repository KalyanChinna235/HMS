package com.health.HMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Region {
    @Id
    private String council;

    @NotBlank(message = "Region name is required")
    private String region;
}
