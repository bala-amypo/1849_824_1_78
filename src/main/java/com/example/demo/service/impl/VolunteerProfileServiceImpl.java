// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.repository.VolunteerProfileRepository;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class VolunteerProfileServiceImpl implements VolunteerProfileService {

//     private final VolunteerProfileRepository repository;

//     public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VolunteerProfile createVolunteer(VolunteerProfile profile) {

//         if (repository.existsByVolunteerId(profile.getVolunteerId())) {
//             throw new BadRequestException("Volunteer ID already exists");
//         }
//         if (repository.existsByEmail(profile.getEmail())) {
//             throw new BadRequestException("Email already exists");
//         }
//         if (repository.existsByPhone(profile.getPhone())) {
//             throw new BadRequestException("Phone already exists");
//         }

//         return repository.save(profile);
//     }

//     @Override
//     public VolunteerProfile getVolunteerById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new BadRequestException("Volunteer not found"));
//     }

//     @Override
//     public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
//         return repository.findByVolunteerId(volunteerId);
//     }

//     @Override
//     public List<VolunteerProfile> getAllVolunteers() {
//         return repository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;
    private final PasswordEncoder passwordEncoder;

    public VolunteerProfileServiceImpl(
            VolunteerProfileRepository repository,
            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER VOLUNTEER
    @Override
    public VolunteerProfile registerVolunteer(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        VolunteerProfile profile = new VolunteerProfile();
        profile.setFullName(request.getFullName());
        profile.setEmail(request.getEmail());
        profile.setPassword(passwordEncoder.encode(request.getPassword()));
        profile.setAvailabilityStatus("AVAILABLE");

        return repository.save(profile);
    }

    // ✅ UPDATE AVAILABILITY
    @Override
    public VolunteerProfile updateAvailability(Long id, String status) {

        VolunteerProfile profile = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));

        if (!status.equals("AVAILABLE") && !status.equals("UNAVAILABLE")) {
            throw new BadRequestException("Invalid availability status");
        }

        profile.setAvailabilityStatus(status);
        return repository.save(profile);
    }

    // ✅ GET AVAILABLE VOLUNTEERS
    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }

    // ✅ GET VOLUNTEER BY ID
    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));
    }

    // ✅ GET ALL VOLUNTEERS
    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }
}
