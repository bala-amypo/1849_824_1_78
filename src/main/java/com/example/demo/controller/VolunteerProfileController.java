// // package com.example.demo.controller;

// // import com.example.demo.model.VolunteerProfile;
// // import com.example.demo.service.VolunteerProfileService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.Collections;
// // import java.util.List;

// // @RestController
// // @RequestMapping("/volunteers")
// // public class VolunteerProfileController {

// //     private final VolunteerProfileService service;

// //     public VolunteerProfileController(VolunteerProfileService service) {
// //         this.service = service;
// //     }

// //     @PostMapping("/register")
// //     public VolunteerProfile registerVolunteer() {
// //         return null;
// //     }

// //     @PutMapping("/{id}/availability")
// //     public void updateAvailability(@PathVariable Long id,
// //                                    @RequestParam String status) {
// //     }

// //     @GetMapping("/available")
// //     public List<VolunteerProfile> getAvailableVolunteers() {
// //         return Collections.emptyList();
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.service.VolunteerProfileService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// @RestController
// @RequestMapping("/api/volunteers")
// public class VolunteerProfileController {

//     private final VolunteerProfileService service;

//     public VolunteerProfileController(VolunteerProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public VolunteerProfile createVolunteer(
//             @RequestBody VolunteerProfile volunteer) {
//         return service.createVolunteer(volunteer);
//     }

//     @GetMapping
//     public List<VolunteerProfile> getAllVolunteers() {
//         return service.getAllVolunteers();
//     }
// }
package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    @Autowired
    private VolunteerProfileService volunteerProfileService;

    @PostMapping
    public ResponseEntity<VolunteerProfile> createVolunteer(@RequestBody VolunteerProfile volunteer) {
        if (volunteer.getVolunteerId() == null || volunteer.getVolunteerId().isEmpty()) {
            throw new BadRequestException("Volunteer ID is required");
        }
        VolunteerProfile created = volunteerProfileService.createVolunteer(volunteer);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerProfile> getVolunteerById(@PathVariable Long id) {
        VolunteerProfile volunteer = volunteerProfileService.getVolunteerById(id);
        return ResponseEntity.ok(volunteer);
    }

    @GetMapping
    public ResponseEntity<List<VolunteerProfile>> getAllVolunteers() {
        List<VolunteerProfile> volunteers = volunteerProfileService.getAllVolunteers();
        return ResponseEntity.ok(volunteers);
    }


}