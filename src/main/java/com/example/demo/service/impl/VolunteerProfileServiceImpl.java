// package com.example.demo.service;

// import com.example.demo.model.VolunteerProfile;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class VolunteerProfileServiceImpl
//         implements VolunteerProfileService {

//     @Override
//     public VolunteerProfile createVolunteerProfile(VolunteerProfile volunteerProfile) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public VolunteerProfile getVolunteerById(Long id) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {
//         throw new UnsupportedOperationException("Not yet implemented");
//     }

//     @Override
//     public List<VolunteerProfile> getAllVolunteers() {  
//         throw new UnsupportedOperationException("Not yet implemented");
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {

        if (repository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {

        VolunteerProfile profile = getVolunteerById(id);
        profile.setAvailabilityStatus(availabilityStatus);
        return repository.save(profile);
    }
}
