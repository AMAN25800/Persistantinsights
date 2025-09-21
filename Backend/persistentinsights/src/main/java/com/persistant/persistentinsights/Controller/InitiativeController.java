package com.persistant.persistentinsights.Controller;

import com.persistant.persistentinsights.model.Initiative;
import com.persistant.persistentinsights.repo.InitiativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/initiatives")
@CrossOrigin(origins = "*")
public class InitiativeController {

    @Autowired
    private InitiativeRepository initiativeRepository;

    // Get all initiatives
    @GetMapping
    public List<Initiative> getAllInitiatives() {
        return initiativeRepository.findAll();
    }

    // Get initiatives by project
    @GetMapping("/project/{projectId}")
    public List<Initiative> getInitiativesByProject(@PathVariable String projectId) {
        return initiativeRepository.findByProjectId(projectId);
    }

    // Get single initiative by ID
    @GetMapping("/{id}")
    public Optional<Initiative> getInitiativeById(@PathVariable String id) {
        return initiativeRepository.findById(id);
    }

    // Add new initiative
    @PostMapping
    public Initiative addInitiative(@RequestBody Initiative initiative) {
        return initiativeRepository.save(initiative);
    }

    // Update initiative
    @PutMapping("/{id}")
    public Initiative updateInitiative(@PathVariable String id, @RequestBody Initiative updatedInitiative) {
        return initiativeRepository.findById(id).map(initiative -> {
            initiative.setName(updatedInitiative.getName());
            initiative.setProjectId(updatedInitiative.getProjectId());
            initiative.setDescription(updatedInitiative.getDescription());
            return initiativeRepository.save(initiative);
        }).orElseGet(() -> {
            updatedInitiative.setId(id);
            return initiativeRepository.save(updatedInitiative);
        });
    }

    // Delete initiative
    @DeleteMapping("/{id}")
    public String deleteInitiative(@PathVariable String id) {
        initiativeRepository.deleteById(id);
        return "Initiative with ID " + id + " has been deleted";
    }
}
