package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController{
    @Autowired
    private TaskAssignmentService ts;
    @PostMapping("/TaskRecord")
    public User addTaskRecord(@RequestBody TaskRecord  tr){
        return ts.createUser(tr);
    }
}