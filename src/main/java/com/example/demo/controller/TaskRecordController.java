// package com.example.demo.controller;

// import com.example.demo.model.TaskRecord;
// import com.example.demo.service.TaskRecordService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/tasks")
// public class TaskRecordController {

//     @Autowired
//     private TaskRecordService taskRecordService;
 
//     @PostMapping
//     public TaskRecord createTask(@RequestBody TaskRecord taskRecord) {
//         return taskRecordService.createTask(taskRecord);
//     }
 
//     @PutMapping("/{id}")
//     public TaskRecord updateTask(
//             @PathVariable Long id,
//             @RequestBody TaskRecord updated) {
//         return taskRecordService.updateTask(id, updated);
//     }
 
//     @GetMapping("/open")
//     public List<TaskRecord> getOpenTasks() {
//         return taskRecordService.getOpenTasks();
//     }
 
//     @GetMapping("/code/{code}")
//     public TaskRecord getTaskByCode(@PathVariable String code) {
//         return taskRecordService.getTaskByCode(code);
//     }
//     @GetMapping
//     public List<TaskRecord> getAllTasks() {
//         return taskRecordService.getAllTasks();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService taskService;

    public TaskRecordController(TaskRecordService taskService) {
        this.taskService = taskService;
    }

    // GET /tasks  ✅ FIXES YOUR ERROR
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /tasks/open
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskService.getOpenTasks();
    }

    // GET /tasks/{id}
    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // POST /tasks
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }
}
