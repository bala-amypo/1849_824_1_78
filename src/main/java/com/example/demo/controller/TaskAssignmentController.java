package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;
 
    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }
 
    @PostMapping("/{taskId}")
    public ResponseEntity<TaskAssignmentRecord> assignTask(
            @PathVariable Long taskId) {

        TaskAssignmentRecord assignment =
                taskAssignmentService.assignTask(taskId);

        return ResponseEntity.ok(assignment);
    }

  
    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByTask(
            @PathVariable Long taskId) {

        return ResponseEntity.ok(
                taskAssignmentService.getAssignmentsByTask(taskId)
        );
    }

     
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByVolunteer(
            @PathVariable Long volunteerId) {

        return ResponseEntity.ok(
                taskAssignmentService.getAssignmentsByVolunteer(volunteerId)
        );
    }

   
    @GetMapping
    public ResponseEntity<List<TaskAssignmentRecord>> getAllAssignments() {
        return ResponseEntity.ok(
                taskAssignmentService.getAllAssignments()
        );
    }
}
