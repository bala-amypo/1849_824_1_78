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
package com.example.volunteer.controller;

import com.example.volunteer.entity.VolunteerProfile;
import com.example.volunteer.service.VolunteerProfileService;
import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteer Profile Controller", description = "Volunteer management APIs")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // POST /api/volunteers
    @Operation(summary = "Create volunteer")
    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile volunteer) {
        return service.createVolunteer(volunteer);
    }

    // GET /api/volunteers/{id}
    @Operation(summary = "Get volunteer by ID")
    @GetMapping("/{id}")
    public VolunteerProfile getVolunteer(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    // GET /api/volunteers
    @Operation(summary = "List all volunteers")
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    // PUT /api/volunteers/{id}/availability
    @Operation(summary = "Update volunteer availability status")
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String availability) {
        return service.updateAvailability(id, availability);
    }

    // GET /api/volunteers/lookup/{volunteerId}
    @Operation(summary = "Lookup volunteer by ID")
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile lookupVolunteer(@PathVariable Long volunteerId) {
        return service.lookupVolunteer(volunteerId);
    }
}
