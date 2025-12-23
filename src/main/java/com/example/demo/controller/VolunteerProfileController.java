package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class VolunteerProfileController{
    @Autowired
    private VolunteerProfileService v;
    @PostMapping("/VolunteerProfile")
    public VolunteerProfile addVolunteerProfile(@RequestBody VolunteerProfile vp){
        return v.createVolunteerProfile(vp);
    }
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id){
        return v.getVolunteerById(id);
    }
    @PutMapping("/update/{id}")
    public VolunteerProfile changeAvailability(@PathVariable Long id,@RequestBody String availabilityStatus){
        return v.updateAvailability(id,availabilityStatus);
    }
}