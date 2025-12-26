package com.example.demo.repository;

import com.example.demo.model.VolunteerSkillRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    // ✅ MUST be EXACT (tests assert this)
    List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);
}
