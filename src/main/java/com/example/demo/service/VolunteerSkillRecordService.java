package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;

import java.util.List;

public interface VolunteerSkillRecordService {

    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);

    VolunteerSkillRecord addSkill(VolunteerSkillRecord record);
}
