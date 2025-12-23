package com.example.demo.service.impl;
import com.example.demo.repository. VolunteerProfileRepository;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class  VolunteerProfileServiceImpl implements  VolunteerProfileService{

@Autowired
 VolunteerProfileRepository vps;
public VolunteerProfile createVolunteerProfile( VolunteerProfile vp){

    return vps.save(vp);
}

public VolunteerProfile getVolunteerById(Long id){
    return vps.getVolunteerById(id);
}

}