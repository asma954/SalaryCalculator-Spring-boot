package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ITJuniorTrainee extends SpecialistJuniorTrainee {

    private String programmingLanguages;

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public double calculateTransportAllowance() {

        return 8 * getBasicSalary() / 100;
    }
}
