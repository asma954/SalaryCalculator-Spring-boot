package com.example.ref.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int numberOfEmployees;
    private double revenue;
    private String industry;
    private String website;
    private boolean isPubliclyListed;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employee.setCompany(this);
        this.employees.add(employee);
        this.numberOfEmployees++;
    }

    public void removeEmployee(Employee employee) {
        employee.setCompany(null);
        this.employees.remove(employee);
        this.numberOfEmployees--;
    }

    public int getTotalEmployees() {
        return this.numberOfEmployees;
    }

    public double getAverageSalary() {
        if (this.employees.isEmpty()) {
            return 0.0;
        }
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getBasicSalary();
        }
        return totalSalary / this.employees.size();
    }

    public double getTotalAnnualExpenses() {
        return this.getAverageSalary() * this.numberOfEmployees * 12;
    }

    public boolean isProfitable() {
        return this.revenue > this.getTotalAnnualExpenses();
    }

    public double calculateEmployeeTurnoverRate() {

        int employeesJoined = 0;
        int employeesLeft = 0;
        for (Employee employee : employees) {
            if (employee.getJoiningDate() != null && employee.getJoiningDate().isAfter(LocalDate.now().minusYears(1))) {
                employeesJoined++;
            }
            if (employee.getResignationDate() != null && employee.getResignationDate().isAfter(LocalDate.now().minusYears(1))) {
                employeesLeft++;
            }
        }
        if (employeesJoined == 0) {
            return 0;
        }
        return (double) employeesLeft / employeesJoined * 100;
    }

    public void promoteEmployee(Employee employee, String newRole) {

        employee.setRole(newRole);
    }

    public void organizeTeamBuildingEvent(String eventName) {

        System.out.println("Team-building event '" + eventName + "' scheduled for next month!");
    }


    public double calculateAverageExperience() {
        double totalExperience = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getJoiningDate() != null) {
                totalExperience += LocalDate.now().getYear() - employee.getJoiningDate().getYear();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return totalExperience / count;
    }


    public double calculateTotalBonusPaidLastYear() {
        double totalBonus = 0;
        for (Employee employee : employees) {
            if (employee.getBonus() != null && employee.getJoiningDate() != null &&
                    employee.getJoiningDate().isBefore(LocalDate.now().minusYears(1))) {
                totalBonus += employee.getBonus();
            }
        }
        return totalBonus;
    }


    public boolean isAnniversaryCelebrationToday() {

        return LocalDate.now().getMonthValue() == 1 && LocalDate.now().getDayOfMonth() == 1;
    }
}
