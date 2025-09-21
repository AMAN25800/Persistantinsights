package com.persistant.persistentinsights.Controller;

import com.persistant.persistentinsights.model.Client;
import com.persistant.persistentinsights.model.Project;
import com.persistant.persistentinsights.repo.ClientRepository;
import com.persistant.persistentinsights.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();
        List<Client> clients = clientRepository.findAll();
        List<Project> projects = projectRepository.findAll();

        summary.put("totalClients", clients.size());
        summary.put("totalProjects", projects.size());
        summary.put("activeProjects", projects.stream().filter(p -> "Active".equalsIgnoreCase(p.getStatus())).count());
        return summary;
    }
}
