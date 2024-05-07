package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class MarketingStrategistTrainee extends BusinessJuniorTrainee {
    private String areaOfFocus;

    public String getAreaOfFocus() {
        return areaOfFocus;
    }

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    @Override
    public double calculateTransportAllowance() {
         
        return 8 * getBasicSalary() / 100;
    }
}
