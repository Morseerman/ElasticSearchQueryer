package com.example.elasticsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.elasticsearch.es2.MyService;
import com.example.elasticsearch.es2.ObjectModel;


@SpringBootApplication
@RestController
public class ElasticsearchApplication {

	public ElasticsearchApplication(){};
	public static HashMap jsonMap;

	public static void main(String[] args) throws IOException {	
		MyService ms = new MyService();
		ms.save(new ObjectModel("Bob", "Is cool!"));
		RequestHandler rh = new RequestHandler();
		jsonMap =  rh.sendGetRequest();	
		SpringApplication.run(ElasticsearchApplication.class, args);
	
	}

	@GetMapping("/o")
	public List<String> supBitch(){
		return List.of("hi", "there");
	}
	@GetMapping("/p")
	public HashMap<String, Object> supDitch(){
		return jsonMap;
	}



}
