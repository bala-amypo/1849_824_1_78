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
 
    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }
 
    @PostMapping
    public ResponseEntity<VolunteerProfile> createVolunteer(
            @RequestBody VolunteerProfile volunteer) {

        return ResponseEntity.ok(
                volunteerProfileService.createVolunteer(volunteer)
        );
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<VolunteerProfile> getVolunteerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                volunteerProfileService.getVolunteerById(id)
        );
    }
 
    @GetMapping("/lookup/{volunteerId}")
    public ResponseEntity<Optional<VolunteerProfile>> getByVolunteerId(
            @PathVariable String volunteerId) {

        return ResponseEntity.ok(
                volunteerProfileService.findByVolunteerId(volunteerId)
        );
    }

   
    @GetMapping
    public ResponseEntity<List<VolunteerProfile>> getAllVolunteers() {

        return ResponseEntity.ok(
                volunteerProfileService.getAllVolunteers()
        );
    }

  
    @GetMapping("/available")
    public ResponseEntity<List<VolunteerProfile>> getAvailableVolunteers() {

        return ResponseEntity.ok(
                volunteerProfileService.getAvailableVolunteers()
        );
    }
}
