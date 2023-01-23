package com.example.elasticsearch.es2;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "myindex")
public class ObjectModel {
    @Id
    public String id;
    public String name;
    public String description;
    

    public ObjectModel(String name, String description){
        this.name = name;
        this.description = description;
    }
}
