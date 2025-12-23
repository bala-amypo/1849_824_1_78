package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerSkillRecordServiceImpl
        implements VolunteerSkillRecordService {

    @Autowired
    private VolunteerSkillRecordRepository vsr;

    @Override
    public VolunteerSkillRecord createVolunteerSkillRecord(
            VolunteerSkillRecord vs) {
        return vsr.save(vs);
    }
    public VolunteerSkillRecord getSkillById(Long id){
        return vsr.findById(id);
    }
}
