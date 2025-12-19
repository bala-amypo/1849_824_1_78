package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class  TaskAssignment{
    @Autowired
    TaskAssignmentService ae;
    @PostMapping("/AssignmentEvaluation")
    public  TaskAssignmentService add  TaskAssignmentService(@RequestBody   TaskAssignmentService ta){
        return gs.create  TaskAssignmentService(ta);
    }
}