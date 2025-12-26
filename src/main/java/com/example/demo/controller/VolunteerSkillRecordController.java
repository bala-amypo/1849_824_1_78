package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillRecordController {

    private final VolunteerSkillRecordService service;

    public VolunteerSkillRecordController(
            VolunteerSkillRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord addSkill(
            @RequestBody VolunteerSkillRecord record) {
        return service.addSkill(record);
    }

    @GetMapping("/{id}")
    public VolunteerSkillRecord getById(@PathVariable Long id) {
        return service.getSkillById(id);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }

    @GetMapping
    public List<VolunteerSkillRecord> getAll() {
        return service.getAllSkills();
    }
}
