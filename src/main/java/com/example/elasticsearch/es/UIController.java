package com.example.elasticsearch.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UIController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listRobotDocuments",elasticSearchQuery.searchAllDocuments());
        return "index";
    }

    @PostMapping("/saveRobot")
    public String saveRobot(@ModelAttribute("robot") Robot robot) throws IOException {
        elasticSearchQuery.createOrUpdateDocument(robot);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {

        Robot robot = elasticSearchQuery.getDocumentById(id);
        model.addAttribute("robot", robot);
        return "updateRobotDocument";
    }

    @GetMapping("/showNewRobotForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Robot robot = new Robot();
        model.addAttribute("robot", robot);
        return "newRobotDocument";
    }

    @GetMapping("/deleteRobot/{id}")
    public String deleteRobot(@PathVariable(value = "id") String id) throws IOException {

        this.elasticSearchQuery.deleteDocumentById(id);
        return "redirect:/";
    }
}