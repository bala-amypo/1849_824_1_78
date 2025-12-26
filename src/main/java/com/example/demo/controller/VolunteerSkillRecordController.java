package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillRecordController {

    @Autowired
    private VolunteerSkillRecordService vo;

    // 1. Add or Update Skill
    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(
            @RequestBody VolunteerSkillRecord skill) {
        return vo.addOrUpdateSkill(skill);
    }

    // 2. Get Skill by Skill ID
    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkillById(@PathVariable Long id) {
        return vo.getSkillById(id);
    }

    // 3. Get Skills by Volunteer ID
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {
        return vo.getSkillsByVolunteer(volunteerId);
    }

    // 4. Get All Skills
    @GetMapping
    public List<VolunteerSkillRecord> getAllSkills() {
        return vo.getAllSkills();
    }
}
