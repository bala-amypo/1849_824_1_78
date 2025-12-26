package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    @Autowired
    private VolunteerProfileService volunteerProfileService;

    // POST /api/volunteers - Create volunteer
    @PostMapping
    public VolunteerProfile createVolunteer(
            @RequestBody VolunteerProfile volunteerProfile) {
        return volunteerProfileService.createVolunteerProfile(volunteerProfile);
    }

    // GET /api/volunteers/{id} - Get volunteer
    @GetMapping("/{id}")
    public VolunteerProfile getVolunteerById(@PathVariable Long id) {
        return volunteerProfileService.getVolunteerById(id);
    }

    // GET /api/volunteers - List all
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }

    // PUT /api/volunteers/{id}/availability - Update status
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestBody String availabilityStatus) {
        return volunteerProfileService.updateAvailability(id, availabilityStatus);
    }

    // GET /api/volunteers/lookup/{volunteerId} - Lookup by ID
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile lookupVolunteer(
            @PathVariable Long volunteerId) {
        return volunteerProfileService.getVolunteerById(volunteerId);
    }
}
