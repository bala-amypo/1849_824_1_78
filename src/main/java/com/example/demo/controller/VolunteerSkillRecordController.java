package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerSkill;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VolunteerSkillRecordController{
    @Autowired
    private VolunteerSkillService vo;
    @PostMapping("/VolunteerProfile")
    public VolunteerProfile addVolunteerSkill(@RequestBody VolunteerSkill vs){
        return vo.createVolunteerSkill(vs);
    }
}