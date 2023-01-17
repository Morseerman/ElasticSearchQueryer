package com.example.elasticsearch;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestHandler {
    public void sendGetRequest() throws IOException{
        URL url = new URL("https://backpack.tf/api/IGetCurrencies/v1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        
        System.out.println(con.getContentEncoding());
    }
}
