package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TaskAssignmentRecordService {

    public TaskAssignmentRecord createTaskAssignmentRecord(TaskAssignmentRecord ts) {
        // TODO: Save to repository
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public TaskAssignmentRecord assignTask(Long taskId) {
        // TODO: Implement task assignment logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public TaskAssignmentRecord updateAssignmentStatus(Long id, String status) {
        // TODO: Implement status update logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<TaskAssignmentRecord> getAllAssignments() {
        // TODO: Implement retrieval logic
        throw new UnsupportedOperationException("Not yet implemented");
    }
}