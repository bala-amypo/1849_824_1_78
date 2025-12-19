package com.example.demo.service.impl;
import com.example.demo.repository. VolunteerSkillRepository;
import com.example.demo.entity. VolunteerSkill;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class  VolunteerSkillServiceImpl implements  VolunteerSkillService{

@Autowired
 VolunteerSkillRepository vsr;
public  VolunteerSkill create VolunteerSkill( VolunteerSkill ae){

    return aer.save(ae);
}


}