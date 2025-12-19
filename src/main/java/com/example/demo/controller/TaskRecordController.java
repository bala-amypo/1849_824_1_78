package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.TaskAssignment;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class   TaskRecord{
    @Autowired
    TaskRecordService trs;
    @PostMapping("/TaskRecord")
    public  TaskAssignmentService addTaskRecordService(@RequestBody   TaskAssignmentService tr){
        return trs.create  TaskRecordService(tr);
    }
}