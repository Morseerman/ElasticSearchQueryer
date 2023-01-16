package com.example.elasticsearch;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.elasticsearch.person.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
@RestController
public class ElasticsearchApplication {

	public ElasticsearchApplication(){};

	Person p;
	public static void main(String[] args) throws IOException {	
		RequestHandler rh = new RequestHandler();
		rh.sendGetRequest();	
		SpringApplication.run(ElasticsearchApplication.class, args);
	
	}

	@GetMapping("/o")
	public List<String> supBitch(){
		return List.of("hi", "there");
	}



}
