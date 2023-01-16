package com.example.elasticsearch.person;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class PersonService {
    public String getStuff(){
        return "poop";
    }

    public List<String> getList(){
        return List.of("Apple", "Bottom", "Jeans");
    }

    public Person getPerson(){
        ObjectMapper mapper = new ObjectMapper();
                
        return new Person("Jamz", 10, false);
    }
}
