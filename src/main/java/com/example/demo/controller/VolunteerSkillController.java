package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;
 
    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }
 
    @PostMapping
    public ResponseEntity<VolunteerSkillRecord> addOrUpdateSkill(
            @RequestBody VolunteerSkillRecord skill) {

        return ResponseEntity.ok(
                volunteerSkillService.addOrUpdateSkill(skill)
        );
    }
 
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {

        return ResponseEntity.ok(
                volunteerSkillService.getSkillsByVolunteer(volunteerId)
        );
    }
}
