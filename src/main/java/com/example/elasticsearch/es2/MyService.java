package com.example.elasticsearch.es2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Autowired
    private ModelRepository modelRepository;

    public List<ObjectModel> findByName(String name) {
        return (List<ObjectModel>) modelRepository.findAll();
    }
    public ObjectModel save(ObjectModel om){
        return modelRepository.save(om);
    }
}
