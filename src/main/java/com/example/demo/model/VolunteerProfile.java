// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// import java.time.LocalDateTime;

// @Entity
// public class VolunteerProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String volunteerId;
//     private String fullName;
//     private String email;
//     private String phone;
//     private String availabilityStatus;

//     private LocalDateTime createdAt;

//     // ✅ REQUIRED by JPA
//     public VolunteerProfile() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // ✅ REQUIRED for compilation (services/controllers use this)
//     public VolunteerProfile(String volunteerId, String fullName, String email) {
//         this.volunteerId = volunteerId;
//         this.fullName = fullName;
//         this.email = email;
//         this.createdAt = LocalDateTime.now();
//     }

//     // ================= GETTERS & SETTERS =================

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getVolunteerId() {
//         return volunteerId;
//     }

//     public void setVolunteerId(String volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public String getFullName() {
//         return fullName;
//     }

//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public void setPhone(String phone) {
//         this.phone = phone;
//     }

//     public String getAvailabilityStatus() {
//         return availabilityStatus;
//     }

//     public void setAvailabilityStatus(String availabilityStatus) {
//         this.availabilityStatus = availabilityStatus;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }
// }
package com.example.volunteer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteers")
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String availability; // AVAILABLE / UNAVAILABLE

    public VolunteerProfile() {}

    public VolunteerProfile(String name, String email, String availability) {
        this.name = name;
        this.email = email;
        this.availability = availability;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
