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
package com.example.volunteer.service;

import com.example.volunteer.entity.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile volunteer);

    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();

    VolunteerProfile updateAvailability(Long id, String availability);

    VolunteerProfile lookupVolunteer(Long volunteerId);
}
