package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class   VolunteerProfile{
    @Autowired
    TaskRecordService vps;
    @PostMapping("/VolunteerSkillRecord")
    public  VolunteerSkillRecordService addVolunteerProfileService(@RequestBody   VolunteerProfileService vp){
        return vps.create  UserService(vp);
    }
}