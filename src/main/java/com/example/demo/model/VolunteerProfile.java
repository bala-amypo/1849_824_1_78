// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "volunteer_profiles")
// public class VolunteerProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @Column(unique = true)
//     private String email;

//     private String availabilityStatus;

//     // ✅ No-arg constructor (REQUIRED)
//     public VolunteerProfile() {
//     }

//     // ✅ Parameterized constructor (REQUIRED BY TESTS)
//     public VolunteerProfile(String name, String email, String availabilityStatus) {
//         this.name = name;
//         this.email = email;
//         this.availabilityStatus = availabilityStatus;
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getEmail() {
//         return email;
//     }
    
//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getAvailabilityStatus() {
//         return availabilityStatus;
//     }

//     public void setAvailabilityStatus(String availabilityStatus) {
//         this.availabilityStatus = availabilityStatus;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volunteerId;
    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
