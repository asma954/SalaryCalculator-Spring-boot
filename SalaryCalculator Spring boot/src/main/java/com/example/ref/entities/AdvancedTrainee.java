package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AdvancedTrainee extends Trainee {

    private String specializedField;

    public String getSpecializedField() {
        return specializedField;
    }

    public void setSpecializedField(String specializedField) {
        this.specializedField = specializedField;
    }

    @Override
    public double calculateTransportAllowance() {

        return 12 * getBasicSalary() / 100;
    }
}
