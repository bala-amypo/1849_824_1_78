package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class VolunteerSkillRecordController{
    @Autowired
    private VolunteerSkillRecordService vo;
    @PostMapping("/VolunteerSkillRecord")
    public VolunteerSkillRecord addVolunteerSkillRecord(@RequestBody VolunteerSkillRecord vs){
        return vo.createVolunteerSkillRecord(vs);
    }
    @GetMapping("/{id}")
    public VolunteerSkillRecord volunteerId(@PathVariable Long id){
        return vo.getSkillById(id);
}
}