package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TaskAssignmentRecord")
public class TaskAssignmentRecordController {

    @Autowired
    private TaskAssignmentRecordService taskAssignmentRecordService;

    @PostMapping
    public TaskAssignmentRecord addTaskAssignmentRecord(@RequestBody TaskAssignmentRecord ta) {
        return taskAssignmentRecordService.createTaskAssignmentRecord(ta);
    }

    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return taskAssignmentRecordService.assignTask(taskId);
    }

    @PutMapping("/status/{id}")
    public TaskAssignmentRecord updateAssignmentStatus(@PathVariable Long id, @RequestParam String status) {
        return taskAssignmentRecordService.updateAssignmentStatus(id, status);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
        return taskAssignmentRecordService.getAssignmentsByVolunteer(volunteerId);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(@PathVariable Long taskId) {
        return taskAssignmentRecordService.getAssignmentsByTask(taskId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRecordService.getAllAssignments();
    }
}