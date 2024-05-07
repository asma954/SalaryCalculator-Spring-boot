package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalLeadSeniorManager extends LeadSeniorManager {

    private int numberOfGlobalOffices;

    public int getNumberOfGlobalOffices() {
        return numberOfGlobalOffices;
    }

    public void setNumberOfGlobalOffices(int numberOfGlobalOffices) {
        this.numberOfGlobalOffices = numberOfGlobalOffices;
    }

    @Override
    public double calculateTransportAllowance() {

        return 30 * getBasicSalary() / 100;
    }
}
