package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;

@RestController
public class AssignmentEvaluationController {

    @Autowired
    private AssignmentEvaluationService assignmentEvaluationService;

    @PostMapping("/assignment-evaluations")
    public AssignmentEvaluation addEvaluation(
            @RequestBody AssignmentEvaluation evaluation) {

        return assignmentEvaluationService.createEvaluation(evaluation);
    }
}
