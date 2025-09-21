package com.persistant.persistentinsights.repo;

import com.persistant.persistentinsights.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByClientId(String clientId);
}
