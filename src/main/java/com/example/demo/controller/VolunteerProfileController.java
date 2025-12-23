package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
    publilc VolunteerProfile changeAvail(Long id,String availabilityStatus);
}