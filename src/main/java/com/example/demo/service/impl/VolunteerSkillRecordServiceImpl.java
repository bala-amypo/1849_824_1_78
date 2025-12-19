package com.example.demo.service.impl;
import com.example.demo.repository. VolunteerSkillRepository;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class  VolunteerSkillRecordServiceImpl implements  VolunteerSkillRecordService{

@Autowired
 VolunteerSkillRecordRepository vsr;
public  VolunteerSkillRecord createVolunteerSkillRecord(VolunteerSkillRecord vs){

    return vsr.save(vs);
}


}