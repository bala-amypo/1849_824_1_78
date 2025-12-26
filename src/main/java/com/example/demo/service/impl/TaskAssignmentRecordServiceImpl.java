package com.example.demo.service.impl;

import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TaskAssignmentRecordServiceImpl implements TaskAssignmentRecordService {

    @Autowired
    private TaskAssignmentRecordRepository tar;

    @Override
    public TaskAssignmentRecord createTaskAssignmentRecord(TaskAssignmentRecord ta) {
        return tar.save(ta);
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        // TODO: Implement task assignment logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public TaskAssignmentRecord updateAssignmentStatus(Long id, String status) {
        // TODO: Implement status update logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }
}