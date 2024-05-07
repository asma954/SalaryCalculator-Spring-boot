package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessJuniorTrainee extends SpecialistJuniorTrainee {

    private String businessSkills;

    public String getBusinessSkills() {
        return businessSkills;
    }

    public void setBusinessSkills(String businessSkills) {
        this.businessSkills = businessSkills;
    }

    @Override
    public double calculateTransportAllowance() {

        return 7.5 * getBasicSalary() / 100;
    }
}
