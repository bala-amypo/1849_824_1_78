package com.example.demo.service.impl;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.entity.TaskAssignment;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TaskRecordImpl implements TaskRecordService{

@Autowired
TaskRecordRepository trr;
public  TaskRecord createTaskRecord(TaskRecord tr){

    return trr.save(tr);
}


}