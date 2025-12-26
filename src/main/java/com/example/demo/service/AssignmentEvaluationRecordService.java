package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;

public interface AssignmentEvaluationRecordService {

  
    AssignmentEvaluationRecord createAssignmentEvaluationRecord(AssignmentEvaluationRecord as);
 
    AssignmentEvaluationRecord getAssignmentEvaluationById(Long id);
}
