package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public VolunteerProfile registerVolunteer() {
        return null;
    }

    @PutMapping("/{id}/availability")
    public void updateAvailability(@PathVariable Long id,
                                   @RequestParam String status) {
    }

    @GetMapping("/available")
    public List<VolunteerProfile> getAvailableVolunteers() {
        return Collections.emptyList();
    }
}
