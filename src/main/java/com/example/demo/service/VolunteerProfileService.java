// package com.example.demo.service;

// import com.example.demo.model.VolunteerProfile;
// import java.util.List;
// import java.util.Optional;

// public interface VolunteerProfileService {

//     VolunteerProfile createVolunteer(VolunteerProfile profile);

//     VolunteerProfile getVolunteerById(Long id);

//     Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

//     List<VolunteerProfile> getAllVolunteers();
// }
package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    // ✅ Register a new volunteer
    VolunteerProfile registerVolunteer(RegisterRequest request);

    // ✅ Update availability status
    VolunteerProfile updateAvailability(Long id, String status);

    // ✅ Get all available volunteers
    List<VolunteerProfile> getAvailableVolunteers();

    // (Optional but useful)
    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();
}
