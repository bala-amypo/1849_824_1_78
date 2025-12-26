package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
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
    public VolunteerProfile registerVolunteer(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("email already exists");
        }

        String availability = request.getAvailabilityStatus();
        if (!"AVAILABLE".equalsIgnoreCase(availability)
                && !"UNAVAILABLE".equalsIgnoreCase(availability)) {
            throw new BadRequestException("Invalid availability status");
        }

        VolunteerProfile volunteer = new VolunteerProfile(
                request.getName(),
                request.getEmail(),
                availability.toUpperCase()
        );

        return repository.save(volunteer);
    }

    @Override
    public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {

        VolunteerProfile volunteer = repository.findById(volunteerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));

        if (!"AVAILABLE".equalsIgnoreCase(availabilityStatus)
                && !"UNAVAILABLE".equalsIgnoreCase(availabilityStatus)) {
            throw new BadRequestException("Invalid availability status");
        }

        volunteer.setAvailabilityStatus(availabilityStatus.toUpperCase());
        return repository.save(volunteer);
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }
}
