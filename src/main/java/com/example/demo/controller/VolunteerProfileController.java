// package com.example.demo.controller;

// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.web.bind.annotation.*;

// import java.util.Collections;
// import java.util.List;

// @RestController
// @RequestMapping("/volunteers")
// public class VolunteerProfileController {

//     private final VolunteerProfileService service;

//     public VolunteerProfileController(VolunteerProfileService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public VolunteerProfile registerVolunteer() {
//         return null;
//     }

//     @PutMapping("/{id}/availability")
//     public void updateAvailability(@PathVariable Long id,
//                                    @RequestParam String status) {
//     }

//     @GetMapping("/available")
//     public List<VolunteerProfile> getAvailableVolunteers() {
//         return Collections.emptyList();
//     }
// }
 package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // POST /volunteers
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VolunteerProfile createVolunteer(
            @RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    // GET /volunteers/{id}
    @GetMapping("/{id}")
    public VolunteerProfile getVolunteerById(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    // GET /volunteers
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    // GET /volunteers/lookup/{volunteerId}
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile findByVolunteerId(
            @PathVariable String volunteerId) {
        return service.findByVolunteerId(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
