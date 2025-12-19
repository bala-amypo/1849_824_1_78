package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskAssignmentRecordController{
    @Autowired
    private TaskAssignmentRecordService t;
    @PostMapping("/TaskAssignmentRecord")
    public TaskAssignmentRecord addTaskAssignmentRecord(@RequestBody TaskAssignmentRecord ta){
        return t.createTaskAssignmentRecord(ta);
    }
}