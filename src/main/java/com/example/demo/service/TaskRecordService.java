package com.example.demo.service.impl;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.entity.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService{

@Autowired
TaskAssignmentRepository trs;
public TaskAssignment createAssignment(TaskAssignment ta){

    return trs.save(ta);
}


}