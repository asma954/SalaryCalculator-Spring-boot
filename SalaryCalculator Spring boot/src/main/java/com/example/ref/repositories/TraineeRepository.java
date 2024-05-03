package com.example.ref.repositories;

import com.example.ref.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    // You can add custom query methods here if needed
}
