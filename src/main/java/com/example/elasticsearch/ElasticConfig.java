package com.example.elasticsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.cdi.ElasticsearchRepositoryBean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.example.elasticsearch.person.Person;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch")
@ComponentScan(basePackages = { "com.baeldung.spring.data.es.service" })
public class ElasticConfig extends ElasticsearchRepository<Person, String>{

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration 
            = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
