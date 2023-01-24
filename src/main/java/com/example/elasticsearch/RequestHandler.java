package com.example.elasticsearch;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestHandler {

    
    public RestTemplate restTemplate = new RestTemplate();
    String url = "https://backpack.tf/api/IGetCurrencies/v1?raw=1&key=63c5f625de7b9efd3d0a0a49";
    String apiKey = "63c5f625de7b9efd3d0a0a49";

    String elasticUrl = "http://localhost:9200/userindex4";
   

    public HashMap sendGetRequest(){        
        HashMap<String, Object> response = restTemplate.getForObject(url, HashMap.class);
        
       
        return response;
    }

    public void putData(HashMap jsonMap) throws JsonProcessingException{   
        HashMap<String, Object> map = new HashMap()<>;
        map.put("mappings", jsonMap);
        String jsonString = new ObjectMapper().writeValueAsString(jsonMap);
        
        // Set the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP entity
        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);
        
        restTemplate.put(elasticUrl, entity);      
    }
    public void deleteData(){        
        restTemplate.delete(elasticUrl);;        
              
    }



    
}
