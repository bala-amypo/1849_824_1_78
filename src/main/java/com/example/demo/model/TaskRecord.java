// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "task_records")
// public class TaskRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;

//     private String description;

//     private String requiredSkill;

//     private String requiredSkillLevel;

//     private String status;

//     // ✅ No-arg constructor
//     public TaskRecord() {
//     }

//     // ✅ Parameterized constructor
//     public TaskRecord(String title, String description,
//                       String requiredSkill, String requiredSkillLevel,
//                       String status) {
//         this.title = title;
//         this.description = description;
//         this.requiredSkill = requiredSkill;
//         this.requiredSkillLevel = requiredSkillLevel;
//         this.status = status;
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getDescription() {
//         return description;
//     }
    
//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getRequiredSkill() {
//         return requiredSkill;
//     }

//     public void setRequiredSkill(String requiredSkill) {
//         this.requiredSkill = requiredSkill;
//     }

//     public String getRequiredSkillLevel() {
//         return requiredSkillLevel;
//     }

//     public void setRequiredSkillLevel(String requiredSkillLevel) {
//         this.requiredSkillLevel = requiredSkillLevel;
//     }

//     public String getStatus() {
//         return status;
//     }
    
//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_records")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String taskCode;

    private String taskName;
    private String priority;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String status;

    // ---------- Constructors ----------
    public TaskRecord() {
    }

    // ---------- Getters ----------
    public Long getId() {
        return id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public String getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public String getStatus() {
        return status;
    }

    // ---------- Setters ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
