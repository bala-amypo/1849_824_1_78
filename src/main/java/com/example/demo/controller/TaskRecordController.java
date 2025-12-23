package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord taskRecord) {
        return taskRecordService.createTaskRecord(taskRecord);
    }
    
}
