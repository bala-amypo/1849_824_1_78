package com.example.demo.service.impl;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TaskAssignmentRecordServiceImpl implements TaskAssignmentRecordService{

@Autowired
TaskAssignmentRecordRepository tar;
public TaskAssignmentRecord createTaskAssignmentRecord(TaskAssignmentRecord ta){

    return tar.save(ta);
}


}