package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee {

    @Override
    public double calculateTransportAllowance() {
        return 15 * getBasicSalary() / 100;
    }
}
