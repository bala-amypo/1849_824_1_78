package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.AssignmentEvaluation;
import com.example.demo.service.AssignmentService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class  AssignmentEvaluation{
    @Autowired
    AssignmentEvaluationService ae;
    @PostMapping("/AssignmentEvaluation")
    public Garage addAssignmentEvaluation(@RequestBody AssignmentEvaluation ae){
        return gs.createAssignmentEvaluation(ae);
    }
}