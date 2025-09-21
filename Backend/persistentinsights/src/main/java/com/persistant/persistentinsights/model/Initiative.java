package com.persistant.persistentinsights.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "initiatives")
public class Initiative {
    @Id
    private String id;
    private String name;
    private String projectId;
    private String description;
}
