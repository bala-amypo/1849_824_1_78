package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;

public interface AssignmentEvaluationRecordService {

    // Create a new AssignmentEvaluationRecord
    AssignmentEvaluationRecord createAssignmentEvaluationRecord(AssignmentEvaluationRecord as);

    // Get AssignmentEvaluationRecord by ID
    AssignmentEvaluationRecord getAssignmentEvaluationById(Long id);
}
