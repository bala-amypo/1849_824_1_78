package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentRecordController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(
            @PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }
}
