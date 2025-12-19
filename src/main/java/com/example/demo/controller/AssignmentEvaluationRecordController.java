package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AssignmentEvaluationRecordController{
    @Autowired
    private AssignmentEvaluationRecordService a;
    @PostMapping("/AssignmentEvaluationRecord")
    public AssignmentEvaluationRecord addAssignmentEvaluation(@RequestBody AssignmentEvaluationRecord as){
        return a.createAssignmentEvaluationRecord(as);
    }
}