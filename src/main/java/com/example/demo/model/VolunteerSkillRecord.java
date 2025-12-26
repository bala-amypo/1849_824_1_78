// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "volunteer_skill_records")
// public class VolunteerSkillRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long volunteerId;

//     private String skillName;

//     private String skillLevel;

//     private boolean certified;

//     // ✅ No-arg constructor
//     public VolunteerSkillRecord() {
//     }

//     // ✅ Parameterized constructor
//     public VolunteerSkillRecord(Long volunteerId, String skillName, String skillLevel, boolean certified) {
//         this.volunteerId = volunteerId;
//         this.skillName = skillName;
//         this.skillLevel = skillLevel;
//         this.certified = certified;
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public Long getVolunteerId() {
//         return volunteerId;
//     }

//     public void setVolunteerId(Long volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getSkillName() {
//         return skillName;
//     }

//     public void setSkillName(String skillName) {
//         this.skillName = skillName;
//     }

//     public String getSkillLevel() {
//         return skillLevel;
//     }

//     public void setSkillLevel(String skillLevel) {
//         this.skillLevel = skillLevel;
//     }

//     public boolean isCertified() {
//         return certified;
//     }

//     public void setCertified(boolean certified) {
//         this.certified = certified;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volunteerId;
    private String skillName;
    private String skillLevel;
    private boolean certified;

    private LocalDateTime updatedAt = LocalDateTime.now();

    // getters & setters
    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }

    public boolean isCertified() { return certified; }
    public void setCertified(boolean certified) { this.certified = certified; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
