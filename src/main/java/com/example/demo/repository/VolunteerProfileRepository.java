package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    // ✅ Required by tests (unique email validation)
    boolean existsByEmail(String email);

    // ✅ Required by assignment logic
    List<VolunteerProfile> findByAvailabilityStatus(String availabilityStatus);
}
