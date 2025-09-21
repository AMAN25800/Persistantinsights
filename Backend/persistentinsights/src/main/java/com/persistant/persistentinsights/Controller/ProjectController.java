package com.persistant.persistentinsights.Controller;

import com.persistant.persistentinsights.model.Project;
import com.persistant.persistentinsights.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/client/{clientId}")
    public List<Project> getProjectsByClient(@PathVariable String clientId) {
        return projectRepository.findByClientId(clientId);
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }
}
