package com.example.elasticsearch.es;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.*;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Configuration
public class ElasticConfig {

    @Bean
    public RestClient getRestClient() {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();
        return restClient;
    }

    @Bean
    public ElasticsearchTransport getElasticsearchTransport() {
        return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
    }

    @Bean
    ElasticsearchClient getElasticsearchClient() {
        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
        return client;
    }
}
