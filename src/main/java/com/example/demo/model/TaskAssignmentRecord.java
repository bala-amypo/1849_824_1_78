// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "task_assignment_records")
// public class TaskAssignmentRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long taskId;

//     private Long volunteerId;

//     private String status;

//     // ✅ No-arg constructor
//     public TaskAssignmentRecord() {
//     }

//     // ✅ Parameterized constructor
//     public TaskAssignmentRecord(Long taskId, Long volunteerId, String status) {
//         this.taskId = taskId;
//         this.volunteerId = volunteerId;
//         this.status = status;
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public Long getTaskId() {
//         return taskId;
//     }

//     public Long getVolunteerId() {
//         return volunteerId;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setTaskId(Long taskId) {
//         this.taskId = taskId;
//     }

//     public void setVolunteerId(Long volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status = "ACTIVE";
    private LocalDateTime assignedAt = LocalDateTime.now();

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
