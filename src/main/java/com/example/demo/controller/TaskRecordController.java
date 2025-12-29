// // package com.example.demo.controller;

// // import com.example.demo.model.TaskAssignmentRecord;
// // import com.example.demo.model.TaskRecord;
// // import com.example.demo.service.TaskAssignmentService;
// // import com.example.demo.service.TaskRecordService;

// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/tasks")
// // public class TaskRecordController {

// //     private final TaskRecordService taskService;
// //     private final TaskAssignmentService assignmentService;

// //     public TaskRecordController(TaskRecordService taskService,
// //                                 TaskAssignmentService assignmentService) {
// //         this.taskService = taskService;
// //         this.assignmentService = assignmentService;
// //     }

// //     @PostMapping
// //     public TaskRecord createTask(@RequestBody TaskRecord task) {
// //         return taskService.createTask(task);
// //     }

// //     @GetMapping("/{id}")
// //     public TaskRecord getTask(@PathVariable Long id) {
// //         return taskService.getTaskById(id);
// //     }

// //     @PostMapping("/{taskId}/assign")
// //     public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
// //         return assignmentService.assignTask(taskId);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.TaskRecord;
// import com.example.demo.service.TaskRecordService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// @RestController
// @RequestMapping("/api/tasks")
// public class TaskRecordController {

//     private final TaskRecordService service;

//     public TaskRecordController(TaskRecordService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public TaskRecord createTask(@RequestBody TaskRecord task) {
//         return service.createTask(task);
//     }

//     @GetMapping
//     public List<TaskRecord> getAllTasks() {
//         return service.getAllTasks();
//     }
// }
package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    @PostMapping
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        if (task.getTaskName() == null || task.getTaskName().isEmpty()) {
            throw new BadRequestException("Task name is required");
        }
        TaskRecord created = taskRecordService.createTask(task);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTaskById(@PathVariable Long id) {
        TaskRecord task = taskRecordService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskRecord>> getAllTasks() {
        List<TaskRecord> tasks = taskRecordService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}