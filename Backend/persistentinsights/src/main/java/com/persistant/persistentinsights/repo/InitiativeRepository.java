package com.persistant.persistentinsights.repo;

import com.persistant.persistentinsights.model.Initiative;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InitiativeRepository extends MongoRepository<Initiative, String> {
    List<Initiative> findByProjectId(String projectId);
}
