package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VolunteerSkillRecordController{
    @Autowired
    private VolunteerSkillRecordService vo;
    @PostMapping("/VolunteerSkillRecord")
    public VolunteerSkillRecord addVolunteerSkill(@RequestBody VolunteerSkillRecord vs){
        return vo.createVolunteerSkill(vs);
    }
}