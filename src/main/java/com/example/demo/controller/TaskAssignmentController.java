// // package com.example.demo.controller;

// // import com.example.demo.model.TaskAssignmentRecord;
// // import com.example.demo.service.TaskAssignmentService;

// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/assignments")
// // public class TaskAssignmentRecordController {

// //     private final TaskAssignmentService service;

// //     public TaskAssignmentRecordController(TaskAssignmentService service) {
// //         this.service = service;
// //     }

// //     @GetMapping("/task/{taskId}")
// //     public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
// //         return service.getAssignmentsByTask(taskId);
// //     }

// //     @GetMapping("/volunteer/{volunteerId}")
// //     public List<TaskAssignmentRecord> getByVolunteer(
// //             @PathVariable Long volunteerId) {
// //         return service.getAssignmentsByVolunteer(volunteerId);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.service.TaskAssignmentService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import java.util.List;

// @RestController
// @RequestMapping("/api/task-assignments")
// public class TaskAssignmentRecordController {

//     private final TaskAssignmentService service;

//     public TaskAssignmentRecordController(TaskAssignmentService service) {
//         this.service = service;
//     }

//     @PostMapping("/{taskId}")
//     public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
//         return service.assignTask(taskId);
//     }

//     @GetMapping("/task/{taskId}")
//     public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
//         return service.getAssignmentsByTask(taskId);
//     }

//     @GetMapping("/volunteer/{volunteerId}")
//     public List<TaskAssignmentRecord> getByVolunteer(
//             @PathVariable Long volunteerId) {
//         return service.getAssignmentsByVolunteer(volunteerId);
//     }

//     @GetMapping
//     public List<TaskAssignmentRecord> getAll() {
//         return service.getAllAssignments();
//     }
// }
package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    @PostMapping
    public ResponseEntity<TaskAssignmentRecord> assignTask(@RequestBody TaskAssignmentRecord assignment) {
        if (assignment.getTaskId() == null) {
            throw new BadRequestException("Task ID is required");
        }
        TaskAssignmentRecord created = taskAssignmentService.assignTask(assignment.getTaskId());
        return ResponseEntity.ok(created);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByTask(@PathVariable Long taskId) {
        List<TaskAssignmentRecord> assignments = taskAssignmentService.getAssignmentsByTask(taskId);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
        List<TaskAssignmentRecord> assignments = taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
        return ResponseEntity.ok(assignments);
    }
}