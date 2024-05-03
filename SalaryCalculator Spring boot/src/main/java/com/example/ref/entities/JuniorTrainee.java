package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class JuniorTrainee extends Trainee {

    @Override
    public double calculateTransportAllowance() {
        return 5 * getBasicSalary() / 100;
    }
}
