package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalLeadSeniorManagerOperations extends GlobalLeadSeniorManager {
    private int numberOfCountriesOperated;

    public int getNumberOfCountriesOperated() {
        return numberOfCountriesOperated;
    }

    public void setNumberOfCountriesOperated(int numberOfCountriesOperated) {
        this.numberOfCountriesOperated = numberOfCountriesOperated;
    }

    @Override
    public double calculateTransportAllowance() {

        return 32 * getBasicSalary() / 100;
    }
}
