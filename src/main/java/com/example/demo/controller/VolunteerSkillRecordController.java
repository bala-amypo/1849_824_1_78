package com.example.demo.controller;
import org.springframework.web.bind.annonation.RestController;
import org.springframework.beans.factory.annonation.Autowired;
import com.example.demo.entity.VolunteerSkillRecord;
import com.example.demo.service. VolunteerSkillRecordService;
import org.springframework.web.bind.annonation.PostMapping;
import org.springframework.web.bind.annonation.RequestBody;

@RestController
public class    VolunteerSkillRecord{
    @Autowired
    VolunteerSkillRecordService vsr;
    @PostMapping("/VolunteerSkillRecord")
    public  VolunteerSkillRecordService addVolunteerSkillRecordService(@RequestBody    VolunteerSkillRecordService vs){
        return vsr.create  VolunteerSkillRecordService(vp);
    }
}