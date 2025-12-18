package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.AssignmentEvaluation;

public interface AssignmentEvaluationService


{
    public AssignmentEvaluation registerAssignmentEvaluation(AssignmentEvaluation req);
    public AssignmentEvaluation loginAssignmentEvaluation( AssignmentEvaluation req);
}