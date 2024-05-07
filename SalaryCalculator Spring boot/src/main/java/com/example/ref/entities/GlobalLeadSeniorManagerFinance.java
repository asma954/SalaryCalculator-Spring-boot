package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalLeadSeniorManagerFinance extends GlobalLeadSeniorManager {
    private int numberOfFinancialAnalysts;

    public int getNumberOfFinancialAnalysts() {
        return numberOfFinancialAnalysts;
    }

    public void setNumberOfFinancialAnalysts(int numberOfFinancialAnalysts) {
        this.numberOfFinancialAnalysts = numberOfFinancialAnalysts;
    }

    @Override
    public double calculateTransportAllowance() {

        return 35 * getBasicSalary() / 100;
    }
}
