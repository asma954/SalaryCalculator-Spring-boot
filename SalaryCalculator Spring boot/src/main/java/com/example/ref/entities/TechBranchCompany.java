package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TechBranchCompany extends BranchCompany {
    private String technologyFocus;
    private boolean hasResearchDepartment;

    public String getTechnologyFocus() {
        return technologyFocus;
    }

    public void setTechnologyFocus(String technologyFocus) {
        this.technologyFocus = technologyFocus;
    }

    public boolean isHasResearchDepartment() {
        return hasResearchDepartment;
    }

    public void setHasResearchDepartment(boolean hasResearchDepartment) {
        this.hasResearchDepartment = hasResearchDepartment;
    }
}
