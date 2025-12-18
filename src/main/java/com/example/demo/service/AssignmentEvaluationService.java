package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.AssignmentEvaluation;

public interface AssignmentEvaluationService


{
    public AssignmentEvaluation  registerUser(AssignmentEvaluation req);
    public AssignmentEvaluation loginUser( AssignmentEvaluation req);
}