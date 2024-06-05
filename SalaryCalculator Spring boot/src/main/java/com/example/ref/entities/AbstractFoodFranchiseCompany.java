package com.example.ref.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractFoodFranchiseCompany extends FoodFranchiseCompany {

    private String abstractFoodProperty;

    public String getAbstractFoodProperty() {
        return abstractFoodProperty;
    }

    public void setAbstractFoodProperty(String abstractFoodProperty) {
        this.abstractFoodProperty = abstractFoodProperty;
    }


    public abstract void performAbstractFoodOperation();
}
