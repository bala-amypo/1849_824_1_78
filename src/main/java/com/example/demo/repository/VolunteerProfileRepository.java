// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.VolunteerProfile;
// public interface  VolunteerProfileRepository extends JpaRepository<  VolunteerProfile,Long>{
    
// }
package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByEmail(String email);
}
