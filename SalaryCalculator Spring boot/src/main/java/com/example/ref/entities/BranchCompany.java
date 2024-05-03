package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;



@Entity
@Data
public class BranchCompany extends Company {
    private String parentCompany;


}
