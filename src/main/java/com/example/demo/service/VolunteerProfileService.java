package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteerProfile(VolunteerProfile vp);
    VolunteerProfile getVolunteerById(Long id);
}
