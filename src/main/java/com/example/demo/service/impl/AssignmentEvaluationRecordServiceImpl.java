 package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentEvaluationRecordServiceImpl
        implements AssignmentEvaluationRecordService {

    @Autowired
    private AssignmentEvaluationRecordRepository aer;

    // Create a new record
    @Override
    public AssignmentEvaluationRecord createAssignmentEvaluationRecord(
            AssignmentEvaluationRecord ae) {
        return aer.save(ae);
    }

    // Get record by ID
    @Override
    public AssignmentEvaluationRecord getAssignmentEvaluationById(Long id) {
        return aer.findById(id)
                  .orElseThrow(() ->
                      new RuntimeException("AssignmentEvaluationRecord not found with id: " + id));
    }
}
