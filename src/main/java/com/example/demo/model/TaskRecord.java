package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_records")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String requiredSkill;

    private String requiredSkillLevel;

    private String status;

    // ✅ No-arg constructor
    public TaskRecord() {
    }

    // ✅ Parameterized constructor
    public TaskRecord(String title, String description,
                      String requiredSkill, String requiredSkillLevel,
                      String status) {
        this.title = title;
        this.description = description;
        this.requiredSkill = requiredSkill;
        this.requiredSkillLevel = requiredSkillLevel;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
