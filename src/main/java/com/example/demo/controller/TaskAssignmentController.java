package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;

@RestController
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    @PostMapping("/task-assignments")
    public TaskAssignmentRecord assignTask(@RequestBody TaskAssignmentRecord record) {
        return taskAssignmentService.assignTask(record);
    }
}
