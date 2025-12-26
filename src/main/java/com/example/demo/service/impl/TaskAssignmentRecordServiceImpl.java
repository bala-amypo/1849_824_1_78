package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskAssignmentRecordServiceImpl
        implements TaskAssignmentRecordService {

    @Override
    public TaskAssignmentRecord createTaskAssignmentRecord(TaskAssignmentRecord ts) {
         
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
       
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public TaskAssignmentRecord updateAssignmentStatus(Long id, String status) {
      
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
         
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
         
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
