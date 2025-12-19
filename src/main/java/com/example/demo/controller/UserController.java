package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class   TaskRecord{
    @Autowired
    TaskRecordService uss;
    @PostMapping("/TaskRecord")
    public  UserService addTaskRecordService(@RequestBody   UserService us){
        return uss.create  UserService(us);
    }
}