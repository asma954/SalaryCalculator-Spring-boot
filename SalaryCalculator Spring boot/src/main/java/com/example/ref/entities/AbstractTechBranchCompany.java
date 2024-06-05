package com.example.ref.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractTechBranchCompany extends TechBranchCompany {

    private String abstractProperty;

    public String getAbstractProperty() {
        return abstractProperty;
    }

    public void setAbstractProperty(String abstractProperty) {
        this.abstractProperty = abstractProperty;
    }


    public abstract void performAbstractOperation();
}
