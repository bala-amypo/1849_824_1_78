package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController{
    @Autowired
    private TaskAssignmentService a;
    @PostMapping("/AssignmentEvaluation")
    public User addUser(@RequestBody AssignmentEvaluation as){
        return a.createUser(as);
    }
}