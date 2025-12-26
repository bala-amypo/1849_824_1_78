// package com.example.demo.service;

// import com.example.demo.model.TaskRecord;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class TaskRecordServiceImpl implements TaskRecordService {

//     @Override
//     public TaskRecord createTask(TaskRecord task) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public TaskRecord updateTask(Long id, TaskRecord updated) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public List<TaskRecord> getOpenTasks() {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public TaskRecord getTaskByCode(String code) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public List<TaskRecord> getAllTasks() {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository taskRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        task.setStatus("OPEN");
        return taskRepository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return taskRepository.findByStatus("OPEN");
    }
}
