package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

@RestController
public class VolunteerProfileController {

    @Autowired
    private VolunteerProfileService volunteerProfileService;

    @PostMapping("/volunteers")
    public VolunteerProfile addVolunteer(@RequestBody VolunteerProfile volunteerProfile) {
        return volunteerProfileService.createVolunteer(volunteerProfile);
    }
}
