// package com.example.demo.controller;

// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.service.VolunteerSkillService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/skills")
// public class VolunteerSkillRecordController {

//     private final VolunteerSkillService service;

//     public VolunteerSkillRecordController(VolunteerSkillService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord record) {
//         return service.addOrUpdateSkill(record);
//     }

//     @GetMapping("/volunteer/{volunteerId}")
//     public List<VolunteerSkillRecord> getSkills(@PathVariable Long volunteerId) {
//         return service.getSkillsByVolunteer(volunteerId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer-skills")
public class VolunteerSkillRecordController {

    private final VolunteerSkillService service;

    public VolunteerSkillRecordController(VolunteerSkillService service) {
        this.service = service;
    }

    // 🔥 FIXED METHOD NAME
    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(
            @RequestBody VolunteerSkillRecord skill) {
        return service.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }
}
