package com.example.elasticsearch.person;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(path = "/jay")
public class PersonController{    

    @GetMapping("/k")
    public List<Person> getPeople(){
        return List.of(
            new Person("Rob", 100, false),
            new Person("Lob", 12, true)
        );
    }
}
