// // package com.example.demo.model;

// // import jakarta.persistence.*;

// // @Entity
// // @Table(name = "task_records")
// // public class TaskRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String title;

// //     private String description;

// //     private String requiredSkill;

// //     private String requiredSkillLevel;

// //     private String status;

    
// //     public TaskRecord() {
// //     }

     
// //     public TaskRecord(String title, String description,
// //                       String requiredSkill, String requiredSkillLevel,
// //                       String status) {
// //         this.title = title;
// //         this.description = description;
// //         this.requiredSkill = requiredSkill;
// //         this.requiredSkillLevel = requiredSkillLevel;
// //         this.status = status;
// //     }

// //     // Getters & Setters
// //     public Long getId() {
// //         return id;
// //     }

// //     public String getTitle() {
// //         return title;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public void setTitle(String title) {
// //         this.title = title;
// //     }

// //     public String getDescription() {
// //         return description;
// //     }
    
// //     public void setDescription(String description) {
// //         this.description = description;
// //     }

// //     public String getRequiredSkill() {
// //         return requiredSkill;
// //     }

// //     public void setRequiredSkill(String requiredSkill) {
// //         this.requiredSkill = requiredSkill;
// //     }

// //     public String getRequiredSkillLevel() {
// //         return requiredSkillLevel;
// //     }

// //     public void setRequiredSkillLevel(String requiredSkillLevel) {
// //         this.requiredSkillLevel = requiredSkillLevel;
// //     }

// //     public String getStatus() {
// //         return status;
// //     }
    
// //     public void setStatus(String status) {
// //         this.status = status;
// //     }
// // }
// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "task_records")
// public class TaskRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String taskCode;

//     @Column(nullable = false)
//     private String taskName;

//     private String requiredSkill;

//     private Integer requiredSkillLevel;

//     @Column(nullable = false)
//     private String priority;

//     @Column(nullable = false)
//     private String status;

//     // ✅ Default status required by tests
//     @PrePersist
//     public void setDefaultStatus() {
//         if (this.status == null) {
//             this.status = "OPEN";
//         }
//     }

//     // -------- Getters & Setters --------

//     public Long getId() {
//         return id;
//     }

//     public String getTaskCode() {
//         return taskCode;
//     }

//     public void setTaskCode(String taskCode) {
//         this.taskCode = taskCode;
//     }

//     public String getTaskName() {          // ✅ FIXED
//         return taskName;
//     }

//     public void setTaskName(String taskName) {
//         this.taskName = taskName;
//     }

//     public String getRequiredSkill() {
//         return requiredSkill;
//     }

//     public void setRequiredSkill(String requiredSkill) {
//         this.requiredSkill = requiredSkill;
//     }

//     public Integer getRequiredSkillLevel() {
//         return requiredSkillLevel;
//     }

//     public void setRequiredSkillLevel(Integer requiredSkillLevel) {
//         this.requiredSkillLevel = requiredSkillLevel;
//     }

//     public String getPriority() {           // ✅ FIXED
//         return priority;
//     }

//     public void setPriority(String priority) {
//         this.priority = priority;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔴 REQUIRED BY TESTS
    private String taskCode;

    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status;

    public TaskRecord() {
        this.status = "OPEN";
    }

    public Long getId() {
        return id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public String getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
