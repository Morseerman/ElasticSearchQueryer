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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RequestHandler {

    
    public RestTemplate restTemplate = new RestTemplate();
    String url = "https://backpack.tf/api/IGetCurrencies/v1?raw=1&key=63c5f625de7b9efd3d0a0a49";
    String apiKey = "63c5f625de7b9efd3d0a0a49";

   

    public HashMap sendGetRequest(){        
        HashMap<String, HashMap<String, Object>> response = restTemplate.getForObject(url, HashMap.class);
        
        System.out.println("---> " + response.get("response").get("success"));
        return response;
    }



    
}
