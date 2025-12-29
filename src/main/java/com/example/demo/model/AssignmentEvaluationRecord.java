// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// import java.time.LocalDateTime;

// @Entity
// public class AssignmentEvaluationRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long assignmentId;
//     private Integer rating;
//     private String feedback;
//     private LocalDateTime evaluatedAt;

 
//     public AssignmentEvaluationRecord() {
//         this.evaluatedAt = LocalDateTime.now();
//     }

     
//     public AssignmentEvaluationRecord(Long assignmentId,
//                                       Integer rating,
//                                       String feedback) {
//         this.assignmentId = assignmentId;
//         this.rating = rating;
//         this.feedback = feedback;
//         this.evaluatedAt = LocalDateTime.now();
//     }

    

//     public Long getId() {
//         return id;
//     }

//     public Long getAssignmentId() {
//         return assignmentId;
//     }

//     public void setAssignmentId(Long assignmentId) {
//         this.assignmentId = assignmentId;
//     }

//     public Integer getRating() {
//         return rating;
//     }

//     public void setRating(Integer rating) {
//         this.rating = rating;
//     }

//     public String getFeedback() {
//         return feedback;
//     }

//     public void setFeedback(String feedback) {
//         this.feedback = feedback;
//     }

//     public LocalDateTime getEvaluatedAt() {
//         return evaluatedAt;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_records")
public class AssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;

    private Long volunteerId;

    @Column(nullable = false)
    private String status;

    // ✅ Automatically set default before saving
    @PrePersist
    public void setDefaultStatus() {
        if (this.status == null) {
            this.status = "ACTIVE";
        }
    }

    // ----- Getters & Setters -----

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
