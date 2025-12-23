 package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/assignment-evaluations")
public class AssignmentEvaluationRecordController {

    @Autowired
    private AssignmentEvaluationRecordService a;

    // POST: Create a new AssignmentEvaluationRecord
    @PostMapping
    public AssignmentEvaluationRecord addAssignmentEvaluationRecord(
            @RequestBody AssignmentEvaluationRecord as) {
        return a.createAssignmentEvaluationRecord(as);
    }

    // GET: Fetch AssignmentEvaluationRecord by ID
    @GetMapping("/{id}")
    public AssignmentEvaluationRecord getAssignmentEvaluationRecord(
            @PathVariable Long id) {
        return a.getAssignmentEvaluationById(id);
    }
}
