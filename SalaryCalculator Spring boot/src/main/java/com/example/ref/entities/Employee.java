package com.example.ref.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private long phone;
    private double basicSalary;
    private Double bonus;
    private LocalDate joiningDate;
    private LocalDate resignationDate;
    private String role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public static double calculateSalary(double basicSalary) {
        double specialAllowance = 250.80;
        double hra = 1000.50;
        return basicSalary + (basicSalary * specialAllowance / 100) + basicSalary * hra / 100;
    }

    public double calculateTransportAllowance() {
        return 10 / 100.0 * basicSalary;
    }
}
