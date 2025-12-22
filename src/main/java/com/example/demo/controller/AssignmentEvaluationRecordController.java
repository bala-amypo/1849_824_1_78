package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationRecordService;

import java.util.List;

@RestController
@RequestMapping("/AssignmentEvaluationRecord")
public class AssignmentEvaluationRecordController {

    @Autowired
    private AssignmentEvaluationRecordService service;

    @PostMapping
    public AssignmentEvaluationRecord addAssignmentEvaluationRecord(@RequestBody AssignmentEvaluationRecord record) {
        return service.createAssignmentEvaluationRecord(record);
    }

    @GetMapping("/{id}")
    public AssignmentEvaluationRecord getAssignmentEvaluationRecordById(@PathVariable Long id) {
        return service.getAssignmentEvaluationRecordById(id);
    }

    @GetMapping
    public List<AssignmentEvaluationRecord> getAllAssignmentEvaluationRecords() {
        return service.getAllAssignmentEvaluationRecords();
    }

    @PutMapping("/{id}")
    public AssignmentEvaluationRecord updateAssignmentEvaluationRecord(@PathVariable Long id, @RequestBody AssignmentEvaluationRecord updatedRecord) {
        return service.updateAssignmentEvaluationRecord(id, updatedRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignmentEvaluationRecord(@PathVariable Long id) {
        service.deleteAssignmentEvaluationRecord(id);
    }
}