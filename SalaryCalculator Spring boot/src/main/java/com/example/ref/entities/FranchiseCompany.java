package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;



@Entity
@Data
public class FranchiseCompany extends Company {
    private String franchisorName;
    private String franchiseLocation;


}
