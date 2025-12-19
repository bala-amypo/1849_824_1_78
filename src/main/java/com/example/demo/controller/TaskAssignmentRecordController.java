package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskAssignmentController{
    @Autowired
    private TaskAssignmentRecordService t;
    @PostMapping("/TaskAssignmentRecord")
    public TaskAssignmentRecord addTaskAssignment(@RequestBody TaskAssignmentRecord ta){
        return t.createTaskAssignmentRecord(ta);
    }
}