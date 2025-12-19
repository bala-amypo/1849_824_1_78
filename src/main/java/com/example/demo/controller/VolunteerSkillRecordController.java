package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;

@RestController
public class VolunteerSkillRecordController {

    @Autowired
    private VolunteerSkillRecordService skillService;

    @PostMapping("/volunteer-skills")
    public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord skill) {
        return skillService.createSkill(skill);
    }
}
