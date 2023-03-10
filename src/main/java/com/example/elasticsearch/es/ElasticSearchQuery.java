package com.example.elasticsearch.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ElasticSearchQuery { 

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private final String indexName = "robots";


    public String createOrUpdateDocument(Robot robot) throws IOException {

        IndexResponse response = elasticsearchClient.index(i -> i
                .index(indexName)
                .id(robot.getId())
                .document(robot)
        );
        if(response.result().name().equals("Created")){
            return new StringBuilder("Document has been successfully created.").toString();
        }else if(response.result().name().equals("Updated")){
            return new StringBuilder("Document has been successfully updated.").toString();
        }
        return new StringBuilder("Error while performing the operation.").toString();
    }

    public Robot getDocumentById(String robotId) throws IOException{
        Robot robot = null;
        GetResponse<Robot> response = elasticsearchClient.get(g -> g
                        .index(indexName)
                        .id(robotId),
                        Robot.class
        );

        if (response.found()) {
            robot = response.source();
            System.out.println("robot name " + robot.getName());
        } else {
            System.out.println ("robot not found");
        }

       return robot;
    }

    public String deleteDocumentById(String robotId) throws IOException {

        DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(robotId));

        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
            return new StringBuilder("robot with id " + deleteResponse.id() + " has been deleted.").toString();
        }
        System.out.println("robot not found");
        return new StringBuilder("robot with id " + deleteResponse.id()+" does not exist.").toString();

    }

    public  List<Robot> searchAllDocuments() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index(indexName));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Robot.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Robot> robots = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Robot) object.source()));
            robots.add((Robot) object.source());

        }
        return robots;
    }
}

