package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Trainee extends Employee {

    @Override
    public double calculateTransportAllowance() {
        return 10 / 100 * getBasicSalary();
    }
}
