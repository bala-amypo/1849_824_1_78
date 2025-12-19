package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    @PostMapping("/task-records")
    public TaskRecord addTaskRecord(@RequestBody TaskRecord taskRecord) {
        return taskRecordService.createTaskRecord(taskRecord);
    }
}
