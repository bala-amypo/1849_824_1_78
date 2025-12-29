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
