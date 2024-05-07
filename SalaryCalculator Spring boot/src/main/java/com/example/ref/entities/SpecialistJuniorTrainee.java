package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialistJuniorTrainee extends JuniorTrainee {

    private String areaOfSpecialization;

    public String getAreaOfSpecialization() {
        return areaOfSpecialization;
    }

    public void setAreaOfSpecialization(String areaOfSpecialization) {
        this.areaOfSpecialization = areaOfSpecialization;
    }

    @Override
    public double calculateTransportAllowance() {

        return 7 * getBasicSalary() / 100;
    }
}
