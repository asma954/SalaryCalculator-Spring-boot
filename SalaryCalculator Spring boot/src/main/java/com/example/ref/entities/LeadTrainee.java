package com.example.ref.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class LeadTrainee extends Trainee {

    private String leadershipProgram;

    public String getLeadershipProgram() {
        return leadershipProgram;
    }

    public void setLeadershipProgram(String leadershipProgram) {
        this.leadershipProgram = leadershipProgram;
    }

    @Override
    public double calculateTransportAllowance() {

        return 15 * getBasicSalary() / 100;
    }
}
