package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Override
    public TaskRecord createTask(TaskRecord task) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updated) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public TaskRecord getTaskByCode(String code) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
