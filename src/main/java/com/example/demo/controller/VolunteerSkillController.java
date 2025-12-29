// // package com.example.demo.controller;

// // import com.example.demo.model.VolunteerSkillRecord;
// // import com.example.demo.service.VolunteerSkillService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/skills")
// // public class VolunteerSkillRecordController {

// //     private final VolunteerSkillService service;

// //     public VolunteerSkillRecordController(VolunteerSkillService service) {
// //         this.service = service;
// //     }

// //     @PostMapping
// //     public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord record) {
// //         return service.addOrUpdateSkill(record);
// //     }

// //     @GetMapping("/volunteer/{volunteerId}")
// //     public List<VolunteerSkillRecord> getSkills(@PathVariable Long volunteerId) {
// //         return service.getSkillsByVolunteer(volunteerId);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.service.VolunteerSkillService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// @RestController
// @RequestMapping("/api/volunteer-skills")
// public class VolunteerSkillRecordController {

//     private final VolunteerSkillService service;

//     public VolunteerSkillRecordController(VolunteerSkillService service) {
//         this.service = service;
//     }

//     // 🔥 FIXED METHOD NAME
//     @PostMapping
//     public VolunteerSkillRecord addOrUpdateSkill(
//             @RequestBody VolunteerSkillRecord skill) {
//         return service.addOrUpdateSkill(skill);
//     }

//     @GetMapping("/volunteer/{volunteerId}")
//     public List<VolunteerSkillRecord> getSkillsByVolunteer(
//             @PathVariable Long volunteerId) {
//         return service.getSkillsByVolunteer(volunteerId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    @Autowired
    private VolunteerSkillService volunteerSkillService;

    @PostMapping
    public ResponseEntity<VolunteerSkillRecord> addSkill(@RequestBody VolunteerSkillRecord skill) {
        if (skill.getVolunteerId() == null || skill.getSkillName() == null || skill.getSkillName().isEmpty()) {
            throw new BadRequestException("Volunteer ID and Skill Name are required");
        }
        VolunteerSkillRecord created = volunteerSkillService.addOrUpdateSkill(skill);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        List<VolunteerSkillRecord> skills = volunteerSkillService.getSkillsByVolunteer(volunteerId);
        return ResponseEntity.ok(skills);
    }
}