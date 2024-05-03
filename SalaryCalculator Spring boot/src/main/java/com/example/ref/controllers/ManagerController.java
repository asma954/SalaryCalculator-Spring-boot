package com.example.ref.controllers;

import com.example.ref.entities.Manager;
import com.example.ref.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Optional<Manager> managerOptional = managerRepository.findById(id);
        return managerOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager savedManager = managerRepository.save(manager);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedManager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
        if (!managerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        manager.setId(id);
        Manager updatedManager = managerRepository.save(manager);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        if (!managerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        managerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
