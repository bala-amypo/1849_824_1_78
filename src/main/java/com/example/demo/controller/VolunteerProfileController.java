package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerProfileService;

    // ✅ Constructor Injection
    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    // ✅ Create volunteer
    @PostMapping
    public ResponseEntity<VolunteerProfile> createVolunteer(
            @RequestBody VolunteerProfile volunteer) {

        return ResponseEntity.ok(
                volunteerProfileService.createVolunteer(volunteer)
        );
    }

    // ✅ Get volunteer by DB ID
    @GetMapping("/{id}")
    public ResponseEntity<VolunteerProfile> getVolunteerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                volunteerProfileService.getVolunteerById(id)
        );
    }

    // ✅ Get volunteer by Volunteer ID (BUSINESS KEY)
    @GetMapping("/lookup/{volunteerId}")
    public ResponseEntity<Optional<VolunteerProfile>> getByVolunteerId(
            @PathVariable String volunteerId) {

        return ResponseEntity.ok(
                volunteerProfileService.findByVolunteerId(volunteerId)
        );
    }

    // ✅ Get all volunteers
    @GetMapping
    public ResponseEntity<List<VolunteerProfile>> getAllVolunteers() {

        return ResponseEntity.ok(
                volunteerProfileService.getAllVolunteers()
        );
    }

    // ✅ Get available volunteers
    @GetMapping("/available")
    public ResponseEntity<List<VolunteerProfile>> getAvailableVolunteers() {

        return ResponseEntity.ok(
                volunteerProfileService.getAvailableVolunteers()
        );
    }
}
