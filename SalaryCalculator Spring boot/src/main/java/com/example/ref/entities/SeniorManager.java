package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SeniorManager extends Manager {

    @Override
    public double calculateTransportAllowance() {
        return 20 * getBasicSalary() / 100;
    }
}
