package com.example.elasticsearch.es2;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ModelRepository extends ElasticsearchRepository<ObjectModel, String> {
    
}
