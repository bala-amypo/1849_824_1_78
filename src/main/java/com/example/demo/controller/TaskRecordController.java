package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService taskRecordService;

    // ✅ Constructor Injection
    public TaskRecordController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    // ✅ Create task (status defaults to OPEN in service)
    @PostMapping
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        return ResponseEntity.ok(taskRecordService.createTask(task));
    }

    // ✅ Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskRecordService.getTaskById(id));
    }

    // ✅ Get all tasks
    @GetMapping
    public ResponseEntity<List<TaskRecord>> getAllTasks() {
        return ResponseEntity.ok(taskRecordService.getAllTasks());
    }

    // ✅ REQUIRED by tests & helper document
    @GetMapping("/open")
    public ResponseEntity<List<TaskRecord>> getOpenTasks() {
        return ResponseEntity.ok(taskRecordService.getOpenTasks());
    }
}
