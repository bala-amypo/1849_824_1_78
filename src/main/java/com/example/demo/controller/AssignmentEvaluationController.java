package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;
 
    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> evaluateAssignment(
            @RequestBody AssignmentEvaluationRecord evaluation) {

        AssignmentEvaluationRecord created =
                assignmentEvaluationService.evaluateAssignment(evaluation);

        return ResponseEntity.ok(created);
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getEvaluationsByAssignment(
            @PathVariable Long assignmentId) {

        List<AssignmentEvaluationRecord> evaluations =
                assignmentEvaluationService.getEvaluationsByAssignment(assignmentId);

        return ResponseEntity.ok(evaluations);
    }
}
