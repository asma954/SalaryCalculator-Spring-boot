package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class MobileDeveloperTrainee extends ITJuniorTrainee {
    private String preferredPlatform;

    public String getPreferredPlatform() {
        return preferredPlatform;
    }

    public void setPreferredPlatform(String preferredPlatform) {
        this.preferredPlatform = preferredPlatform;
    }

    @Override
    public double calculateTransportAllowance() {

        return 9 * getBasicSalary() / 100;
    }
}
