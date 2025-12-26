package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerProfileServiceImpl
        implements VolunteerProfileService {

    @Override
    public VolunteerProfile createVolunteerProfile(VolunteerProfile volunteerProfile) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {  
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
