package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class LeadSeniorManager extends SeniorManager {

    private int numberOfRegionsManaged;

    public int getNumberOfRegionsManaged() {
        return numberOfRegionsManaged;
    }

    public void setNumberOfRegionsManaged(int numberOfRegionsManaged) {
        this.numberOfRegionsManaged = numberOfRegionsManaged;
    }

    @Override
    public double calculateTransportAllowance() {

        return 25 * getBasicSalary() / 100;
    }
}
