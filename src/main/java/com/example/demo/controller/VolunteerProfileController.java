package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VolunteerProfileController{
    @Autowired
    private VolunteerProfileService v;
    @PostMapping("/VolunteerProfile")
    public VolunteerProfile addVolunteerProfile(@RequestBody VolunteerProfile vp){
        return v.createVolunteerProfile(vp);
    }

    
}