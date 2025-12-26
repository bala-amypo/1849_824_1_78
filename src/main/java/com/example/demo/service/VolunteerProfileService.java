// package com.example.demo.service;

// import com.example.demo.model.VolunteerProfile;
// import java.util.List;

// public interface VolunteerProfileService {

//     VolunteerProfile createVolunteerProfile(VolunteerProfile volunteerProfile);

//     VolunteerProfile getVolunteerById(Long id);

//     VolunteerProfile updateAvailability(Long id, String availabilityStatus);

//     List<VolunteerProfile> getAllVolunteers();  
// }
package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();

    VolunteerProfile updateAvailability(Long id, String availabilityStatus);
}
