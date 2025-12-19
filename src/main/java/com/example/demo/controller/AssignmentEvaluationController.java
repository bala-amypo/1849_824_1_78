package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController{
    @Autowired
    private AssignmentEvaluationService a;
    @PostMapping("/AssignmentEvaluation")
    public User addAssignment(@RequestBody AssignmentEvaluation as){
        return a.createUser(as);
    }
}