package com.example.ref.controllers;

import com.example.ref.entities.Trainee;
import com.example.ref.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    private final TraineeRepository traineeRepository;

    @Autowired
    public TraineeController(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Trainee>> getAllTrainees() {
        List<Trainee> trainees = traineeRepository.findAll();
        return ResponseEntity.ok(trainees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable Long id) {
        Optional<Trainee> traineeOptional = traineeRepository.findById(id);
        return traineeOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
        Trainee savedTrainee = traineeRepository.save(trainee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainee> updateTrainee(@PathVariable Long id, @RequestBody Trainee trainee) {
        if (!traineeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        trainee.setId(id);
        Trainee updatedTrainee = traineeRepository.save(trainee);
        return ResponseEntity.ok(updatedTrainee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainee(@PathVariable Long id) {
        if (!traineeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        traineeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
