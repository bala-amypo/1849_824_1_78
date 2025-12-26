package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillRecordService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerSkillRecordServiceImpl
        implements VolunteerSkillRecordService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillRecordServiceImpl(
            VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerSkillRecord addSkill(VolunteerSkillRecord record) {
        return repo.save(record);
    }

    @Override
    public VolunteerSkillRecord getSkillById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<VolunteerSkillRecord> getAllSkills() {
        return repo.findAll();
    }
}
