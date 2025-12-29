// // package com.example.demo.service;

// // import com.example.demo.model.VolunteerProfile;
// // import java.util.List;
// // import java.util.Optional;

// // public interface VolunteerProfileService {

// //     VolunteerProfile createVolunteer(VolunteerProfile profile);

// //     VolunteerProfile getVolunteerById(Long id);

// //     Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

// //     List<VolunteerProfile> getAllVolunteers();
// // }
// package com.example.demo.service;

// import com.example.demo.model.VolunteerProfile;
// import java.util.List;

// public interface VolunteerProfileService {

//     VolunteerProfile createVolunteer(VolunteerProfile profile);

//     List<VolunteerProfile> getAllVolunteers();

//     VolunteerProfile getVolunteerById(Long id);
// }
package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {
    
    VolunteerProfile createVolunteer(VolunteerProfile profile);
    
    VolunteerProfile getVolunteerById(Long id);
    
    List<VolunteerProfile> getAllVolunteers();
    
    List<VolunteerProfile> getAvailableVolunteers();
    
    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
    
    VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus);
}