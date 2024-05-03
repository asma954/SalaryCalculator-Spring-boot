package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;



@Entity
@Data
public class FoodFranchiseCompany extends FranchiseCompany {
    private String cuisineType;
    private boolean hasDriveThru;


}
