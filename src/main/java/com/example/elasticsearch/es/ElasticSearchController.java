package com.example.elasticsearch.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @PostMapping("/createOrUpdateDocument")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Robot robot) throws IOException {
          String response = elasticSearchQuery.createOrUpdateDocument(robot);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDocument")
    public ResponseEntity<Object> getDocumentById(@RequestParam String robotId) throws IOException {
        Robot robot =  elasticSearchQuery.getDocumentById(robotId);
        return new ResponseEntity<>(robot, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDocument")
    public ResponseEntity<Object> deleteDocumentById(@RequestParam String robotId) throws IOException {
        String response =  elasticSearchQuery.deleteDocumentById(robotId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/searchDocument")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Robot> robots = elasticSearchQuery.searchAllDocuments();
        return new ResponseEntity<>(robots, HttpStatus.OK);
    }
}

