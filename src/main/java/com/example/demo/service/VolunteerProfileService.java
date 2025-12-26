package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile getVolunteerById(Long id);

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    List<VolunteerProfile> getAllVolunteers();
}
