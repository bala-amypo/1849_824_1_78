package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    // 1. Create task
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord taskRecord) {
        return taskRecordService.createTask(taskRecord);
    }

    // 2. Update task
    @PutMapping("/{id}")
    public TaskRecord updateTask(
            @PathVariable Long id,
            @RequestBody TaskRecord updated) {
        return taskRecordService.updateTask(id, updated);
    }

    // 3. Get open tasks
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskRecordService.getOpenTasks();
    }
 
    @GetMapping("/code/{code}")
    public TaskRecord getTaskByCode(@PathVariable String code) {
        return taskRecordService.getTaskByCode(code);
    }
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskRecordService.getAllTasks();
    }
}
