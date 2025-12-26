package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService taskService;
    private final TaskAssignmentService assignmentService;

    public TaskRecordController(TaskRecordService taskService,
                                TaskAssignmentService assignmentService) {
        this.taskService = taskService;
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public TaskRecord getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/{taskId}/assign")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return assignmentService.assignTask(taskId);
    }
}
