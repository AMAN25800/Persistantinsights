package com.persistant.persistentinsights.repo;

import com.persistant.persistentinsights.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {}
